package com.eueh.yohonow.video.videoviedeo.videovideoson;

import java.util.List;

/**
 * Created by dllo on 16/12/7.
 */

public class BeanVideoVideoSon {

    /**
     * status : 0
     * code : 200000
     * data : {"contents":{"id":"22783","cid":"13483","create_time":"1481019665","publishURL":"http://www.yohoboys.com/channel/detail/index/id/13483","width":580,"height":370,"contentType":1,"title":"这不是暴动，这是Supreme Box帽衫登记现场引发的大混乱！","titleFont":"","subTitleFont":"","subtitle":"","summary":"相信各位都知道12月8日将会迎来Surpeme最狂最经典的Box Logo帽衫发售，到底大家有多渴望拥有这件Supreme Box Logo帽衫呢？我们一起看看纽约的Supreme登记现场。有网友分享了现场的混乱图片，从图片当中看到在铁网一侧拥堵了大量准备登记的潮流爱好者，当铁网拉开大门的一刻，热情","app":1,"updateMd5":"419f5e9888a1498933061ff0f0f68fe2","imgNum":0,"type":1,"videoUrl":"http://video.yohoboys.com/2016/12/6/17/video148101749380874.mp4","images":[{"url":"http://img02.yohoboys.com/contentimg/2016/12/06/17/028e6c2b25567891ca12e11b4e65197ae8.jpg","type":1,"source":"http://video.yohoboys.com/2016/12/6/17/video148101749380874.mp4"}],"content":"<div style=\"font-size:16px;line-height:26px;word-wrap:break-word;text-align:justify\"><style>video{\n    width: 100%;\n    height: auto;\n    visibility: hidden;\n}\n.video_wrap{\n    width:100%;\n    height: 100%;\n    position: absolute;\n}\nvideo{\n}\n.video_outer{\n    position: relative;\n}\n.video_wrap img{\n    height: 100%;\n    width: 100%;\n}\n.play-audio{\n    width: 70px;\n    height: 70px;\n    background: url(http://rescdn.yohoboys.com/res/new/boys/mobile320/images/btn_play.png) no-repeat;\n    background-size: 100% 100%;\n    position: absolute;\n    z-index: 1;\n    top:0;\n    bottom:0;\n    left:0;\n    right:0;\n    margin:auto;\n    border-radius: 100%;\n    -webkit-border-radius: 100%;\n}\nbody p{margin:0 !important;}\n<\/style><p>相信各位都知道12月8日将会迎来Surpeme最狂最经典的Box Logo帽衫发售，到底大家有多渴望拥有这件Supreme Box Logo帽衫呢？我们一起看看纽约的Supreme登记现场。有网友分享了现场的混乱图片，从图片当中看到在铁网一侧拥堵了大量准备登记的潮流爱好者，当铁网拉开大门的一刻，热情的各位蜂拥冲向正确的排队位置。期间多次引起铁网大门人群的推撞，而随后赶到的人也马上奔跑到排队登记的队伍当中。不得不说，如今Surpeme人气的如日中天，令到更多人想拥有Box Logo这款超经典的产品，而超高的市场售价令到不少人却步，只能到现场碰一下运气。要入手Supreme Box Logo帽衫的各位，还是乖乖准备好钱包吧！<\/p><script>function modifyVideo(){\n    var videoArr=document.querySelectorAll('video');\n    var newNode=document.createElement(\"div\");\n    newNode.className='video_wrap';\n    for(var i=0,l=videoArr.length;i<l;i++){\n        var nowNode=videoArr[i];\n        var insertNode=newNode.cloneNode();\n        insertNode.innerHTML=\"<img src='\"+nowNode.getAttribute('poster')+\"'><i class='play-audio'><\/i>\";\n        nowNode.parentNode.insertBefore(insertNode,nowNode);\n    }\n\n    var play_audio=document.querySelectorAll('.play-audio');\n    for(var j=0,l=play_audio.length;j<l;j++){\n        (function(j){\n            play_audio[j].onclick=function(){\n                var pNode=play_audio[j].parentNode;\n                pNode.style.display='none';\n                pNode.nextSibling.style.visibility='visible';\n                pNode.nextSibling.play();\n                setTimeout(function(){pNode.nextSibling.setAttribute('controls','controls')},500);\n            }\n        })(j);\n    }\n}\nmodifyVideo();<\/script><\/div>","total":"0","address":"","gps":"","editor":[],"appEditor":"","tag":[{"tag_name":"时尚","type":1,"tag_id":"2-17"}],"contentTag":[{"tag_name":"Supreme","tag_id":"362","type":2}],"image":"http://img02.yohoboys.com/contentimg/2016/12/06/17/028e6c2b25567891ca12e11b4e65197ae8.jpg"}}
     * message :
     */

    private String status;
    private int code;
    private DataBean data;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * contents : {"id":"22783","cid":"13483","create_time":"1481019665","publishURL":"http://www.yohoboys.com/channel/detail/index/id/13483","width":580,"height":370,"contentType":1,"title":"这不是暴动，这是Supreme Box帽衫登记现场引发的大混乱！","titleFont":"","subTitleFont":"","subtitle":"","summary":"相信各位都知道12月8日将会迎来Surpeme最狂最经典的Box Logo帽衫发售，到底大家有多渴望拥有这件Supreme Box Logo帽衫呢？我们一起看看纽约的Supreme登记现场。有网友分享了现场的混乱图片，从图片当中看到在铁网一侧拥堵了大量准备登记的潮流爱好者，当铁网拉开大门的一刻，热情","app":1,"updateMd5":"419f5e9888a1498933061ff0f0f68fe2","imgNum":0,"type":1,"videoUrl":"http://video.yohoboys.com/2016/12/6/17/video148101749380874.mp4","images":[{"url":"http://img02.yohoboys.com/contentimg/2016/12/06/17/028e6c2b25567891ca12e11b4e65197ae8.jpg","type":1,"source":"http://video.yohoboys.com/2016/12/6/17/video148101749380874.mp4"}],"content":"<div style=\"font-size:16px;line-height:26px;word-wrap:break-word;text-align:justify\"><style>video{\n    width: 100%;\n    height: auto;\n    visibility: hidden;\n}\n.video_wrap{\n    width:100%;\n    height: 100%;\n    position: absolute;\n}\nvideo{\n}\n.video_outer{\n    position: relative;\n}\n.video_wrap img{\n    height: 100%;\n    width: 100%;\n}\n.play-audio{\n    width: 70px;\n    height: 70px;\n    background: url(http://rescdn.yohoboys.com/res/new/boys/mobile320/images/btn_play.png) no-repeat;\n    background-size: 100% 100%;\n    position: absolute;\n    z-index: 1;\n    top:0;\n    bottom:0;\n    left:0;\n    right:0;\n    margin:auto;\n    border-radius: 100%;\n    -webkit-border-radius: 100%;\n}\nbody p{margin:0 !important;}\n<\/style><p>相信各位都知道12月8日将会迎来Surpeme最狂最经典的Box Logo帽衫发售，到底大家有多渴望拥有这件Supreme Box Logo帽衫呢？我们一起看看纽约的Supreme登记现场。有网友分享了现场的混乱图片，从图片当中看到在铁网一侧拥堵了大量准备登记的潮流爱好者，当铁网拉开大门的一刻，热情的各位蜂拥冲向正确的排队位置。期间多次引起铁网大门人群的推撞，而随后赶到的人也马上奔跑到排队登记的队伍当中。不得不说，如今Surpeme人气的如日中天，令到更多人想拥有Box Logo这款超经典的产品，而超高的市场售价令到不少人却步，只能到现场碰一下运气。要入手Supreme Box Logo帽衫的各位，还是乖乖准备好钱包吧！<\/p><script>function modifyVideo(){\n    var videoArr=document.querySelectorAll('video');\n    var newNode=document.createElement(\"div\");\n    newNode.className='video_wrap';\n    for(var i=0,l=videoArr.length;i<l;i++){\n        var nowNode=videoArr[i];\n        var insertNode=newNode.cloneNode();\n        insertNode.innerHTML=\"<img src='\"+nowNode.getAttribute('poster')+\"'><i class='play-audio'><\/i>\";\n        nowNode.parentNode.insertBefore(insertNode,nowNode);\n    }\n\n    var play_audio=document.querySelectorAll('.play-audio');\n    for(var j=0,l=play_audio.length;j<l;j++){\n        (function(j){\n            play_audio[j].onclick=function(){\n                var pNode=play_audio[j].parentNode;\n                pNode.style.display='none';\n                pNode.nextSibling.style.visibility='visible';\n                pNode.nextSibling.play();\n                setTimeout(function(){pNode.nextSibling.setAttribute('controls','controls')},500);\n            }\n        })(j);\n    }\n}\nmodifyVideo();<\/script><\/div>","total":"0","address":"","gps":"","editor":[],"appEditor":"","tag":[{"tag_name":"时尚","type":1,"tag_id":"2-17"}],"contentTag":[{"tag_name":"Supreme","tag_id":"362","type":2}],"image":"http://img02.yohoboys.com/contentimg/2016/12/06/17/028e6c2b25567891ca12e11b4e65197ae8.jpg"}
         */

        private ContentsBean contents;

        public ContentsBean getContents() {
            return contents;
        }

        public void setContents(ContentsBean contents) {
            this.contents = contents;
        }

        public static class ContentsBean {
            /**
             * id : 22783
             * cid : 13483
             * create_time : 1481019665
             * publishURL : http://www.yohoboys.com/channel/detail/index/id/13483
             * width : 580
             * height : 370
             * contentType : 1
             * title : 这不是暴动，这是Supreme Box帽衫登记现场引发的大混乱！
             * titleFont :
             * subTitleFont :
             * subtitle :
             * summary : 相信各位都知道12月8日将会迎来Surpeme最狂最经典的Box Logo帽衫发售，到底大家有多渴望拥有这件Supreme Box Logo帽衫呢？我们一起看看纽约的Supreme登记现场。有网友分享了现场的混乱图片，从图片当中看到在铁网一侧拥堵了大量准备登记的潮流爱好者，当铁网拉开大门的一刻，热情
             * app : 1
             * updateMd5 : 419f5e9888a1498933061ff0f0f68fe2
             * imgNum : 0
             * type : 1
             * videoUrl : http://video.yohoboys.com/2016/12/6/17/video148101749380874.mp4
             * images : [{"url":"http://img02.yohoboys.com/contentimg/2016/12/06/17/028e6c2b25567891ca12e11b4e65197ae8.jpg","type":1,"source":"http://video.yohoboys.com/2016/12/6/17/video148101749380874.mp4"}]
             * content : <div style="font-size:16px;line-height:26px;word-wrap:break-word;text-align:justify"><style>video{
             width: 100%;
             height: auto;
             visibility: hidden;
             }
             .video_wrap{
             width:100%;
             height: 100%;
             position: absolute;
             }
             video{
             }
             .video_outer{
             position: relative;
             }
             .video_wrap img{
             height: 100%;
             width: 100%;
             }
             .play-audio{
             width: 70px;
             height: 70px;
             background: url(http://rescdn.yohoboys.com/res/new/boys/mobile320/images/btn_play.png) no-repeat;
             background-size: 100% 100%;
             position: absolute;
             z-index: 1;
             top:0;
             bottom:0;
             left:0;
             right:0;
             margin:auto;
             border-radius: 100%;
             -webkit-border-radius: 100%;
             }
             body p{margin:0 !important;}
             </style><p>相信各位都知道12月8日将会迎来Surpeme最狂最经典的Box Logo帽衫发售，到底大家有多渴望拥有这件Supreme Box Logo帽衫呢？我们一起看看纽约的Supreme登记现场。有网友分享了现场的混乱图片，从图片当中看到在铁网一侧拥堵了大量准备登记的潮流爱好者，当铁网拉开大门的一刻，热情的各位蜂拥冲向正确的排队位置。期间多次引起铁网大门人群的推撞，而随后赶到的人也马上奔跑到排队登记的队伍当中。不得不说，如今Surpeme人气的如日中天，令到更多人想拥有Box Logo这款超经典的产品，而超高的市场售价令到不少人却步，只能到现场碰一下运气。要入手Supreme Box Logo帽衫的各位，还是乖乖准备好钱包吧！</p><script>function modifyVideo(){
             var videoArr=document.querySelectorAll('video');
             var newNode=document.createElement("div");
             newNode.className='video_wrap';
             for(var i=0,l=videoArr.length;i<l;i++){
             var nowNode=videoArr[i];
             var insertNode=newNode.cloneNode();
             insertNode.innerHTML="<img src='"+nowNode.getAttribute('poster')+"'><i class='play-audio'></i>";
             nowNode.parentNode.insertBefore(insertNode,nowNode);
             }

             var play_audio=document.querySelectorAll('.play-audio');
             for(var j=0,l=play_audio.length;j<l;j++){
             (function(j){
             play_audio[j].onclick=function(){
             var pNode=play_audio[j].parentNode;
             pNode.style.display='none';
             pNode.nextSibling.style.visibility='visible';
             pNode.nextSibling.play();
             setTimeout(function(){pNode.nextSibling.setAttribute('controls','controls')},500);
             }
             })(j);
             }
             }
             modifyVideo();</script></div>
             * total : 0
             * address :
             * gps :
             * editor : []
             * appEditor :
             * tag : [{"tag_name":"时尚","type":1,"tag_id":"2-17"}]
             * contentTag : [{"tag_name":"Supreme","tag_id":"362","type":2}]
             * image : http://img02.yohoboys.com/contentimg/2016/12/06/17/028e6c2b25567891ca12e11b4e65197ae8.jpg
             */

            private String id;
            private String cid;
            private String create_time;
            private String publishURL;
            private int width;
            private int height;
            private int contentType;
            private String title;
            private String titleFont;
            private String subTitleFont;
            private String subtitle;
            private String summary;
            private int app;
            private String updateMd5;
            private int imgNum;
            private int type;
            private String videoUrl;
            private String content;
            private String total;
            private String address;
            private String gps;
            private String appEditor;
            private String image;
            private List<ImagesBean> images;
            private List<?> editor;
            private List<TagBean> tag;
            private List<ContentTagBean> contentTag;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getPublishURL() {
                return publishURL;
            }

            public void setPublishURL(String publishURL) {
                this.publishURL = publishURL;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getContentType() {
                return contentType;
            }

            public void setContentType(int contentType) {
                this.contentType = contentType;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTitleFont() {
                return titleFont;
            }

            public void setTitleFont(String titleFont) {
                this.titleFont = titleFont;
            }

            public String getSubTitleFont() {
                return subTitleFont;
            }

            public void setSubTitleFont(String subTitleFont) {
                this.subTitleFont = subTitleFont;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public int getApp() {
                return app;
            }

            public void setApp(int app) {
                this.app = app;
            }

            public String getUpdateMd5() {
                return updateMd5;
            }

            public void setUpdateMd5(String updateMd5) {
                this.updateMd5 = updateMd5;
            }

            public int getImgNum() {
                return imgNum;
            }

            public void setImgNum(int imgNum) {
                this.imgNum = imgNum;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getVideoUrl() {
                return videoUrl;
            }

            public void setVideoUrl(String videoUrl) {
                this.videoUrl = videoUrl;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getTotal() {
                return total;
            }

            public void setTotal(String total) {
                this.total = total;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }





            public String getGps() {
                return gps;
            }

            public void setGps(String gps) {
                this.gps = gps;
            }

            public String getAppEditor() {
                return appEditor;
            }

            public void setAppEditor(String appEditor) {
                this.appEditor = appEditor;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public List<ImagesBean> getImages() {
                return images;
            }

            public void setImages(List<ImagesBean> images) {
                this.images = images;
            }

            public List<?> getEditor() {
                return editor;
            }

            public void setEditor(List<?> editor) {
                this.editor = editor;
            }

            public List<TagBean> getTag() {
                return tag;
            }

            public void setTag(List<TagBean> tag) {
                this.tag = tag;
            }

            public List<ContentTagBean> getContentTag() {
                return contentTag;
            }

            public void setContentTag(List<ContentTagBean> contentTag) {
                this.contentTag = contentTag;
            }

            public static class ImagesBean {
                /**
                 * url : http://img02.yohoboys.com/contentimg/2016/12/06/17/028e6c2b25567891ca12e11b4e65197ae8.jpg
                 * type : 1
                 * source : http://video.yohoboys.com/2016/12/6/17/video148101749380874.mp4
                 */

                private String url;
                private int type;
                private String source;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getSource() {
                    return source;
                }

                public void setSource(String source) {
                    this.source = source;
                }
            }

            public static class TagBean {
                /**
                 * tag_name : 时尚
                 * type : 1
                 * tag_id : 2-17
                 */

                private String tag_name;
                private int type;
                private String tag_id;

                public String getTag_name() {
                    return tag_name;
                }

                public void setTag_name(String tag_name) {
                    this.tag_name = tag_name;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getTag_id() {
                    return tag_id;
                }

                public void setTag_id(String tag_id) {
                    this.tag_id = tag_id;
                }
            }

            public static class ContentTagBean {
                /**
                 * tag_name : Supreme
                 * tag_id : 362
                 * type : 2
                 */

                private String tag_name;
                private String tag_id;
                private int type;

                public String getTag_name() {
                    return tag_name;
                }

                public void setTag_name(String tag_name) {
                    this.tag_name = tag_name;
                }

                public String getTag_id() {
                    return tag_id;
                }

                public void setTag_id(String tag_id) {
                    this.tag_id = tag_id;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }
            }
        }
    }
}
