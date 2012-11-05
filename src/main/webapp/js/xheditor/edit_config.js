$(pageInit);
function pageInit()
{
	$.extend(xheditor.settings,{skin:'o2007blue',internalScript:true,inlineScript:true,linkTag:true,shortcuts:{'ctrl+enter':submitForm}});//修改默认设置
	$('#Content').xheditor({loadCSS:menuimg_path + 'css/xheditor.css',emotPath:'/images/xheditor_emot/',upLinkUrl:'/admin/upload/link',upLinkExt:'zip,rar,txt,doc,docx',upImgUrl:'/admin/upload/img',upImgExt:'jpg,jpeg,gif,png',upFlashUrl:'/admin/upload/flash',upFlashExt:'swf',upMediaUrl:'/admin/upload/media',upMediaExt:'wmv,avi,wma,mp3,mid'});
}

function insertUpload(msg)
{
	msg=msg[0];
	 $("#uploadList").append('<option value="'+msg.id+'">'+msg.localname+'</option>');
}
function submitForm(){$('#frmDemo').submit();}