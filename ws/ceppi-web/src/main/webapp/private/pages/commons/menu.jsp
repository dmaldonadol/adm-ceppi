<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<aside class="sidebar sidebar-left sidebar-menu">
	<section class="content slimscroll">
		<h5 class="heading">Men&uacute;</h5>
		<ul class="topmenu topmenu-responsive" data-toggle="menu">
			<li ng-repeat="item in menuObj">
				<a href="javascript:void(0);" data-target="#dashboard{{item.codigo}}" data-toggle="submenu" data-parent=".topmenu">
					<span class="figure"> <i class="ico-dashboard2"></i></span> 
					<span class="text">{{item.nombre}}</span>
					<span class="arrow"></span>
				</a>
				<ul id="dashboard{{item.codigo}}" class="collapse ">
					<li class="submenu-header ellipsis">{{item.nombre}}</li>
					<li ng-repeat="subItem in item.itemMenu">
						<a href="{{subItem.path}}"><span class="text">{{subItem.nombre}}</span></a>
					</li>
				</ul>
			</li>
		</ul>
	</section>
</aside>