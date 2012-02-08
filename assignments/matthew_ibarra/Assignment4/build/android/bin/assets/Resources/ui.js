// Matthew Ibarra

(function() {
	gn.ui = {};
	
	gn.ui.createWelcomeScreen = function() {
		var win = Ti.UI.createWindow({
			title:L('welcome_screen'),
			backgroundColor:'#fff'
		});
		
		var view = Titanium.UI.createView({
			borderRadius:10,
			width:'95%',
			height:'95%',
			backgroundColor:'black'
		});
		
		var welcomeLabel = Ti.UI.createLabel({
			text:"Facebook - To Do, Socially.",
			top:'20%'
		})
		
		var fbButton = Ti.Facebook.createLoginButton();
		fbButton.setTop('30%');
		
		Titanium.UI.setBackgroundColor('#fff');
		Titanium.Facebook.appid = '275942449089636';
		Titanium.Facebook.permissions = ['read_stream', 'manage_pages', 'read_friendlists'];
		Titanium.Facebook.addEventListener('login', function(e) {
			if(e.success) {
				alert('Logged in');
				tabGroup.open();
			}
		});
		Titanium.Facebook.addEventListener('logout', function(e) {
			alert('Logged out');
			tabGroup.close();
		});
		if( typeof String.prototype.startsWith != 'function') {
			String.prototype.startsWith = function(str) {
				return this.slice(0, str.length) == str;
			};
		}
		
		view.add(welcomeLabel);
		view.add(fbButton);
		win.add(view);
		
		return win;
	};
	
	gn.ui.createOptionsWindow = function() {
		var win = Ti.UI.createWindow({
			title:L('options'),
			backgroundColor:'#fff'
		});
		
		var view = Titanium.UI.createView({
			borderRadius:10,
			width:'95%',
			height:'95%',
			backgroundColor:'black'
		});
		
		var b = Ti.UI.createButton({
			title:L('back'),
			height:60,
			width:'90%',
			bottom:10
		});
		b.addEventListener('click', function() {
			win.close();
		});
		win.add(view);
		view.add(b);
		
		return win;
	};
})();