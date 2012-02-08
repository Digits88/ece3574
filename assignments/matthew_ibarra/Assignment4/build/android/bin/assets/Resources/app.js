//Matthew Ibarra

Titanium.UI.setBackgroundColor('#ffffff');

var gn = gn || {}; //gn is the name of our apps namespace

//we'll be including all the files for our namespace in the root app context
Ti.include('ui.js');
Ti.include('tableview.js');
Ti.include('tabgroup.js');

var wins = gn.ui.createWelcomeScreen();
var tabGroup = gn.ui.makeTabGroup();
wins.open();
//Use our custom UI constructors to build the app's UI
//var tabs = gn.ui.createApplicationTabGroup();
//tabs.open();

//Log our current platform to the console
//Ti.API.info('Welcome to TiBountyHunter for '+Ti.Platform.osname);