UE.registerUI('button', function (editor, uiName) {
    //注册按钮执行时的command命令，使用命令默认就会带有回退操作
    editor.registerCommand(uiName, {
        execCommand: function () {
            this.execCommand('insertHtml', `<div style="display: inline-block;padding: 8px 16px;border: 1px solid #ccc;border-radius: 5px">请放入链接</div>`);
        }
    });

    //创建一个button
    var btn = new UE.ui.Button({
        //按钮的名字
        name: uiName,
        //提示
        title: "添加按钮",
        //需要添加的额外样式，指定icon图标，这里默认使用一个重复的icon
        cssRules: `background-image:url(${sy.basePath}ueditor/themes/default/images/btn.png)!important;
    background-size: 100% 100%;`,
        //点击时执行的命令
        onclick: function () {
            //这里可以不用执行命令,做你自己的操作也可
            editor.execCommand(uiName);
        }
    });

    //当点到编辑内容上时，按钮要做的状态反射
    editor.addListener('selectionchange', function () {
        var state = editor.queryCommandState(uiName);
        if (state == -1) {
            btn.setDisabled(true);
            btn.setChecked(false);
        } else {
            btn.setDisabled(false);
            btn.setChecked(state);
        }
    });

    //因为你是添加button,所以需要返回这个button
    return btn;
}/*index 指定添加到工具栏上的那个位置，默认时追加到最后,editorId 指定这个UI是那个编辑器实例上的，默认是页面上所有的编辑器都会添加这个按钮*/);

//自定义引用样式例子
UE.registerUI('myblockquote', function (editor, uiName) {
    editor.registerCommand(uiName, {
        execCommand: function () {
            this.execCommand('blockquote', {
                "style": "border-left: 3px solid #E5E6E1; margin-left: 0px; padding-left: 5px; line-height:36px;background:hsla(0, 0%, 80%, 0.19)"
            });

        }
    });

    var btn = new UE.ui.Button({
        name: uiName,
        title: '引用',
        cssRules: "background-position: -220px 0;",
        onclick: function () {
            editor.execCommand(uiName);
        }
    });

    editor.addListener('selectionchange', function () {

        var state = editor.queryCommandState('blockquote');
        if (state == -1) {
            btn.setDisabled(true);
            btn.setChecked(false);
        } else {
            btn.setDisabled(false);
            btn.setChecked(state);
        }
    });

    return btn;
});
//自定义引用样式例子
UE.registerUI('myblockquote1', function (editor, uiName) {
    editor.registerCommand(uiName, {
        execCommand: function () {
            this.execCommand('insertHtml', `<div style="display: inline-block;float: left;vertical-align: middle">在这里放入需要浮动的图片</div>`);

        }
    });

    var btn = new UE.ui.Button({
        name: uiName,
        title: '浮动引用',
        cssRules: "background-position: -220px 0;",
        onclick: function () {
            editor.execCommand(uiName);
        }
    });

    editor.addListener('selectionchange', function () {

        var state = editor.queryCommandState('blockquote');
        if (state == -1) {
            btn.setDisabled(true);
            btn.setChecked(false);
        } else {
            btn.setDisabled(false);
            btn.setChecked(state);
        }
    });

    return btn;
});
function getParentDom(child, parentTagName) {
    if (child.tagName === "HTML") return;
    return child.tagName === parentTagName ? child : getParentDom(child.parentElement, parentTagName);
}

function changeTargetStyleFromParent(parent, childTag, style, callback) {
    const children = parent.children;
    if (children) {
        for (let i = 0, len = children.length; i < len; i++) {
            const dom = children[i];
            if (dom.children.length) changeTargetStyleFromParent(dom, childTag, style,callback);
            if (dom.tagName === childTag) {
                const keys = Object.keys(style);
                //如果有查询到childTag元素则执行回调
                callback && callback(dom);
                keys.forEach(function (key) {
                    dom.style[key] = style[key];
                })
            }
        }
    }
}
const toggleFlag = {removeFlag: false,showBorderFlag:false};
//自定义引用样式例子
UE.registerUI('myblockquote2', function (editor, uiName) {
    editor.registerCommand(uiName, {
        execCommand: function () {
            console.log(1);
            if (toggleFlag.removeFlag) {
                toggleFlag.removeFlag = false;
                alert("关闭清除表格边框功能");
            } else {
                toggleFlag.removeFlag = true;
                alert("开启清除表格边框功能");

            }
        }
    });

    var btn = new UE.ui.Button({
        name: uiName,
        title: '清除单元格边框样式',
        cssRules: "background-position: -220px 0;",
        onclick: function () {

            editor.execCommand(uiName);
        }
    });



    editor.addListener('selectionchange', function () {

        if (toggleFlag.removeFlag) {
            const selectDom = editor.selection.getRange().endContainer;
            if (+selectDom.nodeType === 1) {
                let parentDom = getParentDom(selectDom, "TABLE");
                parentDom && changeTargetStyleFromParent(parentDom, "TD", {
                    border: "none"
                    //    只弹窗一次 并且修改flag
                }, _ => {
                    if (toggleFlag.removeFlag) {
                        alert("清除成功,并已关闭清除功能");
                        toggleFlag.removeFlag = false
                    }
                });


            }
        }

        var state = editor.queryCommandState('blockquote');
        if (state == -1) {
            btn.setDisabled(true);
            btn.setChecked(false);
        } else {
            btn.setDisabled(false);
            btn.setChecked(state);
        }
    });

    return btn;
});

UE.registerUI('myblockquote3', function (editor, uiName) {
    editor.registerCommand(uiName, {
        execCommand: function () {
            console.log(1);
            if (toggleFlag.showBorderFlag) {
                toggleFlag.showBorderFlag = false;
                alert("关闭显示表格边框功能");
            } else {
                toggleFlag.showBorderFlag = true;
                alert("开启显示表格边框功能");

            }
        }
    });

    var btn = new UE.ui.Button({
        name: uiName,
        title: '显示单元格边框样式',
        cssRules: "background-position: -220px 0;",
        onclick: function () {

            editor.execCommand(uiName);
        }
    });



    editor.addListener('selectionchange', function () {

        if (toggleFlag.showBorderFlag) {
            const selectDom = editor.selection.getRange().endContainer;
            if (+selectDom.nodeType === 1) {
                let parentDom = getParentDom(selectDom, "TABLE");
                parentDom && changeTargetStyleFromParent(parentDom, "TD", {
                    border: "1px solid #DDD"
                    //    只弹窗一次 并且修改flag
                }, _ => {
                    if (toggleFlag.showBorderFlag) {
                        alert("显示成功,并已关闭显示边框功能");
                        toggleFlag.showBorderFlag = false
                    }
                });


            }
        }

        var state = editor.queryCommandState('blockquote');
        if (state == -1) {
            btn.setDisabled(true);
            btn.setChecked(false);
        } else {
            btn.setDisabled(false);
            btn.setChecked(state);
        }
    });

    return btn;
});

