"use strict";

define(function () {
    var page = {
        template: "<div id=\"aboutUs\">\n\n<div class=\"cube-container\">\n<div class=\"cube\">\n    <span class=\"cube-face\"></span>\n    <span class=\"cube-face\"></span>\n    <span class=\"cube-face\"></span>\n    <span class=\"cube-face\"><p class=\"cube-title\">\u5373</p></span>\n    <span class=\"cube-face\"><p class=\"cube-title\">\u5BA2</p></span>\n    <span class=\"cube-face\"></span>\n</div>\n</div>\n<div >\n    <div class=\"animate one\">\n        <span>\u6B22</span><span>\u8FCE</span><span>\u767B</span><span>\u9646</span><span>(</span><span>\u5373</span><span>\u5BA2</span><span>)</span><span>\u540E</span><span>\u53F0</span><span>\u7BA1</span><span>\u7406</span><span>\u7CFB\u7EDF!</span>\n    </div>\n    <div class=\"animate two\">\n        <span>\u6B22</span><span>\u8FCE</span><span>\u767B</span><span>\u9646</span><span>(</span><span>\u5373</span><span>\u5BA2</span><span>)</span><span>\u540E</span><span>\u53F0</span><span>\u7BA1</span><span>\u7406</span><span>\u7CFB\u7EDF!</span>\n    </div>\n    <div class=\"animate three\">\n        <span>\u6B22</span><span>\u8FCE</span><span>\u767B</span><span>\u9646</span><span>(</span><span>\u5373</span><span>\u5BA2</span><span>)</span><span>\u540E</span><span>\u53F0</span><span>\u7BA1</span><span>\u7406</span><span>\u7CFB\u7EDF!</span>\n    </div>\n\n</div></div>",
        created: function created() {
            console.log("editor");
        }
    };
    return page;
});
