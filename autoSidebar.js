var sidebarTxt = '';
var path = require('path');
var curPath = path.resolve('./');
var baseDirArr = [];

function walkSync(currentDirPath, callback) {
	var fs = require('fs'),
		path = require('path');
	fs.readdirSync(currentDirPath).forEach(function (name) {
		var filePath = path.join(currentDirPath, name);
		var stat = fs.statSync(filePath);
		if (stat.isFile()) {//是文件
			callback(filePath, stat);
		} else if (stat.isDirectory() && !filePath.includes(".git")) {//是目录但不是.git
			walkSync(filePath, callback);
		}
	});
}

walkSync(curPath, function (filePath, stat) {
	// 只看docs里面的
	if (".md" == path.extname(filePath).toLowerCase()//后缀是.md
		&& "_" != path.basename(filePath).substring(0, 1)
		&& path.basename(filePath).includes(`.md`) && path.dirname(filePath).includes('docs')) {

		var relativeFilePath = filePath.substr(curPath.length + 1);
		if (relativeFilePath == path.basename(filePath)) {//如果最后的string和原来的一样
			return;
		}
		var relativeFilePathArr = relativeFilePath.split('\\')//这里可以看情况改

		for (var i = 0; i < relativeFilePathArr.length; i++) {
			if (baseDirArr[i] == relativeFilePathArr[i]) {//相同就continue
				continue;
			}
			baseDirArr[i] = relativeFilePathArr[i]//记录

			// 过滤docs的展示
			if (relativeFilePathArr[i] == 'docs') {
				continue;
			}

			for (var j = 0; j < i; j++) {
				sidebarTxt += '  '
			}
			if (i != relativeFilePathArr.length - 1) {//如果不是md文件就输出文件夹
				sidebarTxt += '- **' + relativeFilePathArr[i] + '**\n';
			}
			if (i == relativeFilePathArr.length - 1) {//输入md文件夹
				//替换空格
				var link = relativeFilePath.replace(/ +/g, '%20');
				sidebarTxt += '- [' + path.basename(relativeFilePathArr[i],".md") + '](' + link + ')\n';
			}

		}
	}
});

var path = require('path');
var fs = require('fs');

// 替换反斜杠
sidebarTxt = sidebarTxt.replace(/\\/g, '/');
console.log(sidebarTxt);


fs.writeFile(path.resolve('./') + '/_sidebar.md', sidebarTxt, function (err) {
	if (err) {
		console.error(err);
	}
});

