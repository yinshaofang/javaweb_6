//给内置对象中添加新的方法属性
//求最大值
Array.prototype.max=function () {
    var max=this[0];//this指的具体数组对象
    for(var i=0;i<this.length;i++){
        if(this[i]>max){
            max=this[i];
        }
    }
    return max;
};


//求最小值
Array.prototype.min=function () {
    var min=this[0];//this指的具体数组对象
    for(var i=0;i<this.length;i++){
        if(this[i]<min){
            min=this[i];
        }
    }
    return min;
};

//搜索方法
Array.prototype.searchIndex=function (target) {
    for(var i=0;i<this.length;i++){
        if(this[i]==target){
            return i;
        }
    }
    return -1;//表示没找到
}