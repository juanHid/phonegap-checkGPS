exports.check=function(success, error, options){
		options = options || {};
		options.alert = false || options.alert;
		cordova.exec(success, error, "CheckGPS", "check", [options.alert]);
};

exports.open=function(success, error, options){
		options = options || {};
		options.alert = false || options.alert;
		cordova.exec(success, error, "CheckGPS", "open", [options.alert]);
};
