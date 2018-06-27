var reg= /\bis\b/gi;
var str='He is a boy, th Is is a dog where is she?';
str.replace(reg,'IS');
console.log(str.replace(reg,'IS'));

console.log(str.search(reg,'IS'));

var meg= new RegExp('\\bis\\b','gi');


str.replace(meg,'IS');

console.log(str.replace(meg,'IS'));

var str1='a1b2c3d4g5';


console.log(str1.replace(/[avc]/g,'X'));


var str2='a123da23AVCXS4fda2sad';
console.log(str2.replace(/[a-zA-Z]/g,'matt'));

var time='2016-9-12';

console.log(time.replace(/[0-9-]/g,'A'));

var boy='this is a boy';

console.log(boy.replace(/\Bis\b/g,'0'));


var link='@123@dada@';

console.log(link.replace(/^@./g,'Q'));

var numbe4='12345546';

console.log(numbe4.replace(/\d{3,6}/g,'X'));

var number5='a1b2c3d4';

console.log(number5.replace(/([a-z]\d){3}/g,'x'));

var name1='ByronsperByrCasper'.replace(/Byr(on|Ca)sper/g,'X');
console.log(name1);

var timenow='2015-12-01';
console.log(timenow.replace(/(\d{4})-(\d{2})-(\d{2})/g,"$2/$3/$1"));

console.log('a2*3'.replace(/\w(?=\d)/g,'maryhandsome'));


var reg1=/\w/;
var reg2=/\w/gim;

console.log(reg1.global);
console.log(reg1.ignoreCase);
console.log(reg1.multiline);
console.log(reg2.global);
console.log(reg2.ignoreCase);
console.log(reg2.multiline);
//这几个属性是只读的，不能设置

console.log(reg1.source);


var reg3 = /\d(\w)\d/;

var reg4 = /\d(\w)\d/g;

var ts= '1a2b3c4d5e';

var ret= reg3.exec(ts);

console.log(ret);

console.log(reg3.lastIndex+'\t'+ret.index+'\t'+ret.toString());

var a = {name: 1}
var b = a

console.log(a)
console.log(b)

b.name = 2
console.log(a)
console.log(b)

var b = {name: 3}
console.log(a)
console.log(b)



