//
// create controls tab and root window
//
(function() {
	Demo.ui.makeTabGroup = function() {
		var tabGroup = Titanium.UI.createTabGroup();
		var win1 = Titanium.UI.createWindow({
			title : 'Tab 1',
			backgroundColor : '#fff'
		});
		var tab1 = Titanium.UI.createTab({
			icon : 'KS_nav_views.png',
			title : 'Login',
			window : win1
		});

		// add the button.  Note that it doesn't need a click event or anything.
		win1.add(Titanium.Facebook.createLoginButton({
			top : 50,
			style : 'wide'
		}));

		//
		// create controls tab and root window
		//
		var win2 = Titanium.UI.createWindow({
			title : 'Load links',
			backgroundColor : '#fff'
		});
		var tab2 = Titanium.UI.createTab({
			icon : 'KS_nav_ui.png',
			title : 'Load links',
			window : win2
		});

		var currentTab = tab2;

		var getFeed = Ti.UI.createButton({
			title : 'fetch!',
			color : '#800',
			width : Ti.Platform.displayCaps.platformWidth / 4,
			height : Ti.Platform.displayCaps.platformHeight / 4
		});

		var table;
		var actInd = Titanium.UI.createActivityIndicator({
			bottom : 10,
			height : 50,
			width : 10,
			message : 'links found: 0'
		});

		getFeed.addEventListener('click', function() {
			win2.add(actInd);
			actInd.show();
			var data = new Array();
			var newsFeed = Titanium.Facebook.requestWithGraphPath('me/home', {}, 'GET', function(e) {
				if(e.success) {
					var json = JSON.parse(e.result);
					var result = json.data;
					if(result) {
						for(var c = 0; c < result.length; c++) {
							if(result[c].type === 'link') {
								data.push(result[c]);
								actInd.setMessage('Links found: ' + data.length);
							}
						}
						if(data.length <= 4) {
							Ti.App.fireEvent('app:fetchMoreLinks', {
								nextPage : json.paging.next,
								links : data
							});
						} else {
							Ti.App.fireEvent('ui:showTable', {
								links : data
							});
						}
					} else {
						alert('Access token has likely expired.  Please clear credentials and try again.');
					}
				} else if(e.error) {
					alert(e.error);
				} else {
					alert('Unknown response');
				}
			})
		});
		win2.add(getFeed);

		Ti.App.addEventListener('app:fetchMoreLinks', function(e) {
			var xhr = Ti.Network.createHTTPClient();
			xhr.setTimeout(15000);
			xhr.onerror = function(f) {

			};

			xhr.onload = function(f) {

				try {
					var json = JSON.parse(this.responseText);
					var result = json.data;
					for(var c = 0; c < result.length; c++) {
						if(result[c].type === 'link') {
							actInd.setMessage('links found: ' + e.links.length);
							e.links.push(result[c]);
						}
					}
					if(e.links.length <= 4) {
						Ti.App.fireEvent('app:fetchMoreLinks', {
							nextPage : json.paging.next,
							links : e.links
						});
					} else {
						Ti.App.fireEvent('ui:showTable', {
							links : e.links
						});
					}
					//todo fix this object property server bug
				} catch(exception) {//Boot them; no recovery here

				}
			};

			xhr.open('GET', e.nextPage);
			xhr.send();
		});

		Ti.App.addEventListener('ui:showTable', function(e) {
			Ti.API.info('found enough links');
			table = Demo.makeTable(e.links);
			win2.remove(getFeed);
			win2.add(table);
			actInd.hide();
			win2.remove(actInd);
		});

		tab2.addEventListener('click', function() {
			currentTab = tab2;
		});
		tab1.addEventListener('click', function() {
			currentTab = tab1;
		});

		tabGroup.addTab(tab1);
		tabGroup.addTab(tab2);
		return tabGroup;
	};
})();
