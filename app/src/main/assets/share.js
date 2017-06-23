
function shareClick(title, content, imageUrl, linkUrl, shareType, platformType) {
    var dict = {'title':title, 'content':content, 'imageUrl':imageUrl, 'linkUrl':linkUrl, 'shareType':shareType, 'platformType':platformType};
    if (/android/i.test(navigator.userAgent)){
        window.jsObj.share(title, content, imageUrl, linkUrl, shareType, platformType);
    } else {
        window.webkit.messageHandlers.share.postMessage(dict);
    }
}
