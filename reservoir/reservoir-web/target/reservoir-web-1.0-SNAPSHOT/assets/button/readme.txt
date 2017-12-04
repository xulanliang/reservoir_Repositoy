1，样式说明
u-btn 为按钮默认样式

u-btn-c1 为一种样式图标


2，扩展其中一个button样式
同样功能的按钮用一样的样式，比如新增 就都用 u-btn-c3

下列每一列为一种样式的按钮，如果需要新增，直接在最后面加上新增颜色代码
然后在后面的.loop(n); 参数n里填写最后一个样式的序号，如第四种，n=4
(不同button文件夹下面的样式变量不一样)

@c    : #faddde #fef4e9 #e8f0de #606060 ; //color
@bg   : #d81b21 #f78d1d #64991e #fff    ;//background
@hbg  : #b61318 #f47c20 #538018 #ededed ;//hover-bgcolor
@ac   : #de898c #fcd3a5 #a9c08c #999    ;//active - color
@f    : #ed1c24 #f88e11 #7db72f #fff    ;//bgcolor from 
@t    : #aa1317 #f06015 #4e7d0e #ededed ;//bgcolor to 
@bd   : #980c10 #da7c0c #538312 #b7b7b7 ;//boder color
@af   : #aa1317 #f47a20 #4e7d0e #ededed ;//active color from 
@at   : #ed1c24 #faa51a #7db72f #fff    ;//active color to 
@hf   : #c9151b #f88e11 #6b9d28 #fff    ;//hover color from
@ht   : #a11115 #f06015 #436b0c #dcdcdc ;//hover color to;

.loop(@counter) when (@counter > 0) {

    .u-btn-c@{counter}{
        .u-btn-cs(  extract(@c, @counter),extract(@bg, @counter),
                    extract(@hbg, @counter),extract(@ac, @counter),
                    extract(@f, @counter),extract(@t, @counter),
                    extract(@bd, @counter),extract(@af, @counter),
                    extract(@at, @counter),extract(@hf, @counter),
                    extract(@ht, @counter)
        ); 
    }

  .loop((@counter - 1));    // 递归调用自身
}

//样式的个数,生成样式
.loop(4);



3，扩展一个button

/**
 * 1，新建样式必须实现下列样式，u-btn为默认样式，通常是最常见的按钮样式
 * 2，定义三个（除默认）按钮大小样式，分别实现
 * 3，按钮hover fouce active 事件自行实现
 * 4，按照前面以实现的，是用less实现
 */

.u-btn {

}

/* 较大 */
.u-btn-lg {


/* 较小 */
.u-btn-sm {

}
/*很小*/
.u-btn-xs{

}
.u-btn-c1{
	
}