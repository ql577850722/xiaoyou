var data = [];

var dataStr = "1.衡山日出<br>\
<br>\
所在城市：湖南省衡阳市<br>\
活动地点：衡山<br/>\
活动时间：2016-3-20<br>\
<br>\
<br>\
2.自助烤肉<br>\
<br>\
所在城市：湖南省衡阳市<br>\
活动地点：衡山<br/>\
活动时间：2016-3-20<br>\
<br>\
<br>\
3.化装舞会<br>\
<br>\
所在城市：湖南省衡阳市<br>\
活动地点：衡山<br/>\
活动时间：2016-3-20n<br>\
<br>\
<br>\
4.电竞<br>\
<br>\
所在城市：湖南省衡阳市<br>\
活动地点：衡山<br/>\
活动时间：2016-3-20<br>\
<br>\
<br>\
5.骑行<br>\
<br>\
所在城市：湖南省衡阳市<br>\
活动地点：衡山<br/>\
活动时间：2016-3-20<br>\
<br>\
<br>\
6.滑雪<br>\
<br>\
所在城市：湖南省衡阳市<br>\
活动地点：衡山<br/>\
活动时间：2016-3-20<br>\
<br>\
<br>\
7.春游<br>\
<br>\
所在城市：湖南省衡阳市<br>\
活动地点：衡山<br/>\
活动时间：2016-3-20<br>\
"
var d = dataStr.split("<br><br><br>");
for(var i = 0; i<d.length; i++){
  var c = d[i].split("<br><br>");
  var e=c[0].split(".");
  data.push({
    img: e[0]+ ".jpg",
    caption: c[0].split(".")[1],
    desc: c[1]
  });
}

