// Matthew Ibarra

(function() {
	gn.makeTable = function(data) {
		var tableView = Ti.UI.createTableView({
			minRowHeight : 100
		});
		var rows = new Array();
		for(var i = 0; i < data.length; i++) {
			var row = data[i];
			var tvRow = Ti.UI.createTableViewRow({
				height : 'auto',
				selectedBackgroundColor : 'grey',
				backgroundColor : 'white'
			});

			var imageView = Ti.UI.createImageView({
				image : row.picture === null ? 'KS_nav_ui.png' : row.picture,
				left : 10,
				width : 50,
				height : 50,
				rowdata : data[i]
			});
			imageView.addEventListener('click', function(e) {
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
				color : 'black',
				text : row.name
			});
			tvRow.add(newsLabel);
			tvRow.uid = row.id;
			rows.push(tvRow);
		}

		tableView.setData(rows);
		return tableView;
	}
})();
