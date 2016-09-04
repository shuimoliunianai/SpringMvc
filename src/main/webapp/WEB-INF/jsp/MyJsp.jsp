<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>统一文件服务器管理系统</title>
		<link rel="stylesheet" type="text/css" href="/springmvc/ExtJs/resources/css/ext-all.css" />
		<link rel="stylesheet" type="text/css" href="/springmvc/pagesExt/css/style.css" />
        <script type="text/javascript" src="/springmvc/ExtJs/adapter/ext/ext-base.js"></script>
        <script type="text/javascript" src="/springmvc/ExtJs/ext-all.js"></script>
		<script type="text/javascript" src="/springmvc/ExtJs/source/locale/ext-lang-zh_CN.js"></script>
		<script type="text/javascript" src="/springmvc/ExtJs/ext/themeChange.js"></script>
	</head>
	
	<script type="text/javascript">
	
Ext.onReady(function(){  
    Ext.BLANK_IMAGE_URL = 'ExtJs/resources/images/default/s.gif';  
    
    var rootNode = new Ext.tree.AsyncTreeNode({  
        text : "功能菜单",  
        id : "0",  
        expanded : true  
    });  
      
    var tree = new Ext.tree.TreePanel({  
    	el : 'tree_div',
        root : rootNode,  
        autoScroll : true,
		animate : true,
		enableDD : true,
		containerScroll : true,
        loader : new Ext.tree.TreeLoader({  
            dataUrl : './queryFunTree.act'
        }),  
        height : 523
    });  
      
    tree.on("beforeload" , function(node){  
        tree.loader.baseParams.id = node.id;  
       // alert(node.id);
    });  
      
    tree.on("click", function(node){  
        Ext.Ajax.request({  
            url : './queryFunTree.act',  
        //    params : {id:2},  
            success : function(res){  
                var txt = res.responseText;  
              //  var obj = Ext.decode(txt);  
              //  alert(node.attributes.leaf);
             //    alert(obj.length);  
            
            if(node.attributes.leaf){
            	mainPanel.load( {
									url : node.attributes.url,
									callback : function() {
										mainPanel.setTitle(node.text);
									},
									scripts : true
								});
					}else{
				//	alert("1222");
					}
            }  
        });  
    });  
    //tree.setRootNode(rootNode);
  	//tree.render();
    //tree.setRootNode(root);
    					
 //  tree.render(Ext.get("tree_div"));  
      

      new Ext.Viewport( {
					enableTabScroll : true,
					layout : "border",
					items : [ {
						title : "统一文件服务器管理系统",
						region : "north",
						height : 100,
						html : "<img src=pagesExt/images/logo.jpg></img>",
						collapsible : true,
						bbar : [ {
							id : 'BA',
							text : "注册",
							iconCls : 'addup',
							handler : function() {
								window.location.href = "pagesExt/Adduser.jsp";
							}
						}, '->', {
							id : 'CB',
							text : "登录",
							iconCls : 'login',
							handler : function() {
								window.location.href = "pagesExt/Login.jsp";
							}
						} ]

					}, {
						region : 'west',
						collapsible : true,
						title : '功能菜单',
						width : 200,
						//autoScroll : true,
						items : [tree],
						root : tree,
						
						split : true,
						rootVisible : false,
						bbar : [ {
							width : 80,
							listWidth : 80
						} ],
						listeners : {
							'click' : function(node, e) {
						//	var treeValue = Ext.getCmp("tree_div");
							var node=tree.getRootNode();
						//	alert("1");
							if(node.hasChildNodes){
							if(node.isLeaf()){
								mainPanel.load( {
									url : node.attributes.url,
									callback : function() {
										mainPanel.setTitle(node.text);
									},
									scripts : true
								});
								}
								//alert("")
								}
							}
						}
					}, {
						xtype : "tabpanel",
						region : "center",
						id : 'mainContent'
					}

					]
					
				
				});

            
			//	root.expand()
			 var mainPanel = Ext.getCmp('mainContent');
				
});  
</script>
	<body>
		<div id="tree_div"
			style="overflow: auto; height: 800px; width: 250px; border: 1px solid #c3daf9;"></div>
	</body>
</html>