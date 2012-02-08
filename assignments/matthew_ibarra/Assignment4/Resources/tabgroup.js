// Matthew Ibarra

(function() {
	var AddWindow = require('AddWindow').AddWindow;
	
	gn.ui.makeTabGroup = function() {
		var tabGroup = Titanium.UI.createTabGroup();
		var win1 = Titanium.UI.createWindow({
			title : 'Tab 1',
			backgroundColor : '#fff',
			activity: {
				onCreateOptionsMenu: function(e) {
				var menu = e.menu;
			    var menuItem1 = menu.add({ title: "Add Task" });
			    var menuItem2 = menu.add({ title: "Logout" });
			    menuItem1.setIcon("images/ic_menu_add.png");
			    menuItem1.addEventListener("click", function(e) {
				new AddWindow().open();
				    });
				menuItem2.setIcon("images/ic_menu_add.png");
				menuItem2.addEventListener("click", function(e) {
				var logoutWin = Ti.UI.createWindow();
				logoutWin.add(Titanium.Facebook.createLoginButton({
						top : 50,
						style : 'wide'
					}));
				logoutWin.open();
					});
				}
			}
		});
		var tab1 = Titanium.UI.createTab({
			icon : 'KS_nav_views.png',
			title : 'Inbox',
			window : win1
		});
		
		// add the button.  Note that it doesn't need a click event or anything.
		/*win1.add(Titanium.Facebook.createLoginButton({
			top : 50,
			style : 'wide'
		}));
		*/

		//
		// create controls tab and root window
		//
		var win2 = Titanium.UI.createWindow({
			title : 'Outbox',
			backgroundColor : 'white'
		});
		var tab2 = Titanium.UI.createTab({
			icon : 'KS_nav_ui.png',
			title : 'Outbox',
			window : win2
		});

		var currentTab = tab2;

		var getFeed = Ti.UI.createButton({
			title : 'Grab FriendList',
			color : '#800',
			width : '70%',
			height : '30%'
		});

		var table;
		var actInd = Titanium.UI.createActivityIndicator({
			bottom : 10,
			height : 50,
			width : 10,
			message : 'Friends found: 0'
		});

		getFeed.addEventListener('click', function() {
			win2.add(actInd);
			actInd.show();
			var data = new Array();
			var newsFeed = Titanium.Facebook.requestWithGraphPath('me/friends', {}, 'GET', function(e) {
				if(e.success) {
					var json = JSON.parse(e.result);
					var result = json.data;
					if(result) {
						for(var c = 0; c < result.length; c++) {
							data.push(result[c]);
						}
						actInd.setMessage('Friends found: ' + data.length);
						Ti.App.fireEvent('ui:showTable',data);
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


		Ti.App.addEventListener('ui:showTable', function(e) {
			table = gn.makeTable(e);
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
