var Demo = {
	ui : {}
};
Ti.include('tableview.js');

Ti.include('tabgroup.js');

Titanium.UI.setBackgroundColor('#fff');
Titanium.Facebook.appid = '224569824219773';
Titanium.Facebook.permissions = ['read_stream', 'manage_pages'];
Titanium.Facebook.addEventListener('login', function(e) {
	if(e.success) {
		alert('Logged in');
	}
});
Titanium.Facebook.addEventListener('logout', function(e) {
	alert('Logged out');
});
if( typeof String.prototype.startsWith != 'function') {
	String.prototype.startsWith = function(str) {
		return this.slice(0, str.length) == str;
	};
}

var tabGroup = Demo.ui.makeTabGroup();

// open tab group
tabGroup.open();
