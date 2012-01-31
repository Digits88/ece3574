/**
 * @author Anthony
 */
(function() {
	Demo.makeTable = function(data) {
		var tableView = Ti.UI.createTableView({
			minRowHeight : 100
		});
		var rows = new Array();
		for(var i = 0; i < data.length; i++) {
			var row = data[i];
			var tvRow = Ti.UI.createTableViewRow({
				height : 'auto',
				selectedBackgroundColor : '#fff',
				backgroundColor : 'black'
			});

			var imageView = Ti.UI.createImageView({
				image : row.picture === null ? 'KS_nav_ui.png' : row.picture,
				left : 10,
				width : 50,
				height : 50,
				rowdata : data[i]
			});
			imageView.addEventListener('click', function(e) {
				// var url = e.source.rowdata.source.replace('/v/', '/watch?v=');
				// var newUrl = url.substring(0,url.indexOf('?version='));
				Ti.Platform.openURL(e.source.rowdata.source);
			});

			tvRow.add(imageView);

			var newsLabel = Ti.UI.createLabel({
				font : {
					fontSize : 16,
					fontWeight : 'bold'
				},
				left : 70,
				top : 5,
				right : 5,
				height : 20,
				color : '#576996',
				text : row.caption
			});
			tvRow.add(newsLabel);
			tvRow.uid = row.id;
			rows.push(tvRow);
		}

		tableView.setData(rows);
		return tableView;
	}
})();
