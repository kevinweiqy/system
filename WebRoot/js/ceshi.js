$(function() {
   
	$('#tree').tree({    
    url:"/sys/ceshi.action",    
    loadFilter: function(data){    
        if (data.d==0){    
            return data.d;    
        } else {    
            return data;    
        }    
       }    
         }); 

			// 实例化树形菜单
			$("#tree").tree({
						data : treeData,
						lines : true,
						onClick : function(node) {
							if (node.attributes) {
								Open(node.text, node.attributes.url);
							}
						}
					});
			// 在右边center区域打开菜单，新增tab
			function Open(text, url) {
				// 打开一个iframe页面
				var con = '<iframe src="' + url + '" ' + 'height="100%" '
						+ 'width="100%" frameborder="0" '
						+ 'scrolling="no"></iframe>';

				if ($("#tabs").tabs('exists', text)) {
					$('#tabs').tabs('select', text);
				} else {
					$('#tabs').tabs('add', {
								title : text,
								closable : true,
								content : con
							});
				}
			}

			// 绑定tabs的右键菜单
			$("#tabs").tabs({
						onContextMenu : function(e, title) {
							e.preventDefault();
							$('#tabsMenu').menu('show', {
										left : e.pageX,
										top : e.pageY
									}).data("tabTitle", title);
						}
					});

			// 实例化menu的onClick事件
			$("#tabsMenu").menu({
						onClick : function(item) {
							CloseTab(this, item.name);
						}
					});

			// 几个关闭事件的实现
			function CloseTab(menu, type) {
				var curTabTitle = $(menu).data("tabTitle");

				var tabs = $("#tabs");

				if (type === "close") {
					tabs.tabs("close", curTabTitle);
					return;
				}

				var allTabs = tabs.tabs("tabs");
				var closeTabsTitle = [];

				$.each(allTabs, function() {
							var opt = $(this).panel("options");
							if (opt.closable && opt.title != curTabTitle
									&& type === "Other") {
								closeTabsTitle.push(opt.title);
							} else if (opt.closable && type === "All") {
								closeTabsTitle.push(opt.title);
							}
						});

				for (var i = 0; i < closeTabsTitle.length; i++) {
					tabs.tabs("close", closeTabsTitle[i]);
				}
			}
		});