new Vue({
    el:"#app",
    data:{
        loading:true
    },
    created:function () {
        var that = this;
        this.$nextTick(function () {
            $(".article-content-wrapper iframe").load(function () {
                that.loading = false;
            })
        })
    }
});