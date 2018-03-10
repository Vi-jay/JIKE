define(function () {
    const page = {
        template: `<div id="aboutUs">

<div class="cube-container">
<div class="cube">
    <span class="cube-face"></span>
    <span class="cube-face"></span>
    <span class="cube-face"></span>
    <span class="cube-face"><p class="cube-title">即</p></span>
    <span class="cube-face"><p class="cube-title">客</p></span>
    <span class="cube-face"></span>
</div>
</div>
<div >
    <div class="animate one">
        <span>欢</span><span>迎</span><span>登</span><span>陆</span><span>(</span><span>即</span><span>客</span><span>)</span><span>后</span><span>台</span><span>管</span><span>理</span><span>系统!</span>
    </div>
    <div class="animate two">
        <span>欢</span><span>迎</span><span>登</span><span>陆</span><span>(</span><span>即</span><span>客</span><span>)</span><span>后</span><span>台</span><span>管</span><span>理</span><span>系统!</span>
    </div>
    <div class="animate three">
        <span>欢</span><span>迎</span><span>登</span><span>陆</span><span>(</span><span>即</span><span>客</span><span>)</span><span>后</span><span>台</span><span>管</span><span>理</span><span>系统!</span>
    </div>

</div></div>`,
        created: function () {
            console.log("editor");
        }
    };
    return page;
});