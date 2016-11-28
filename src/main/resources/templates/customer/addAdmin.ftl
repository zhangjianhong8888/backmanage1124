
<#include "layout.ftl">

<@layout ; section>
    <#if section = "head">

    <#elseif section = "content" >

    <div class="page-content">

        <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->

        <div id="portlet-config" class="modal hide">

            <div class="modal-header">

                <button data-dismiss="modal" class="close" type="button"></button>

                <h3>portlet Settings</h3>

            </div>

            <div class="modal-body">

                <p>Here will be a configuration form</p>

            </div>

        </div>

        <!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->

        <!-- BEGIN PAGE CONTAINER-->

        <div class="container-fluid">

            <!-- BEGIN PAGE HEADER-->

            <div class="row-fluid">

                <div class="span12">

                    <!-- BEGIN STYLE CUSTOMIZER -->

                    <div class="color-panel hidden-phone">

                        <div class="color-mode-icons icon-color"></div>

                        <div class="color-mode-icons icon-color-close"></div>

                        <div class="color-mode">

                            <p>THEME COLOR</p>

                            <ul class="inline">

                                <li class="color-black current color-default" data-style="default"></li>

                                <li class="color-blue" data-style="blue"></li>

                                <li class="color-brown" data-style="brown"></li>

                                <li class="color-purple" data-style="purple"></li>

                                <li class="color-grey" data-style="grey"></li>

                                <li class="color-white color-light" data-style="light"></li>

                            </ul>

                            <label>

                                <span>Layout</span>

                                <select class="layout-option m-wrap small">

                                    <option value="fluid" selected>Fluid</option>

                                    <option value="boxed">Boxed</option>

                                </select>

                            </label>

                            <label>

                                <span>Header</span>

                                <select class="header-option m-wrap small">

                                    <option value="fixed" selected>Fixed</option>

                                    <option value="default">Default</option>

                                </select>

                            </label>

                            <label>

                                <span>Sidebar</span>

                                <select class="sidebar-option m-wrap small">

                                    <option value="fixed">Fixed</option>

                                    <option value="default" selected>Default</option>

                                </select>

                            </label>

                            <label>

                                <span>Footer</span>

                                <select class="footer-option m-wrap small">

                                    <option value="fixed">Fixed</option>

                                    <option value="default" selected>Default</option>

                                </select>

                            </label>

                        </div>

                    </div>

                    <!-- END BEGIN STYLE CUSTOMIZER -->

                    <h3 class="page-title">

                        Form Layouts

                        <small>form layouts and more</small>

                    </h3>

                    <ul class="breadcrumb">

                        <li>

                            <i class="icon-home"></i>

                            <a href="index.html">Home</a>

                            <span class="icon-angle-right"></span>

                        </li>

                        <li>

                            <a href="#">Form Stuff</a>

                            <span class="icon-angle-right"></span>

                        </li>

                        <li><a href="#">Form Layouts</a></li>

                    </ul>

                </div>

            </div>

            <!-- END PAGE HEADER-->

            <!-- BEGIN PAGE CONTENT-->

            <div class="row-fluid">

                <div class="span12">

                    <!-- BEGIN SAMPLE FORM PORTLET-->

                    <div class="portlet box blue tabbable">

                        <div class="portlet-title">

                            <div class="caption">

                                <i class="icon-reorder"></i>

                                <span class="hidden-480">General Layouts</span>

                            </div>

                        </div>

                        <div class="portlet-body form">

                            <div class="tabbable portlet-tabs">

                                <ul class="nav nav-tabs">

                                    <li><a href="#" data-toggle="tab">Inline</a></li>

                                    <li><a href="#" data-toggle="tab">Grid</a></li>

                                    <li class="active"><a href="javaScript:;" onclick="addCustomerApi()" data-toggle="tab">Default</a></li>

                                </ul>

                                <div class="tab-content">

                                    <div class="tab-pane active" id="portlet_tab1">

                                        <!-- BEGIN FORM-->

                                        <form action="#" class="form-horizontal" method="post">

                                            <div id="cloneAddCustomerApi">

                                                <div id="addCustomerApi">

                                                    <div class="control-group">

                                                        <label class="control-label">姓名</label>

                                                        <div class="controls">

                                                            <input type="text" id="price" name="price" class="m-wrap medium">

                                                            <span id="priceMsg" class="help-inline"></span>

                                                        </div>

                                                    </div>

                                                    <div class="control-group">

                                                        <label class="control-label">登录名</label>

                                                        <div class="controls">

                                                            <input type="text" id="price" name="price" class="m-wrap medium">

                                                            <span id="priceMsg" class="help-inline"></span>

                                                        </div>

                                                    </div>

                                                    <div class="control-group">

                                                        <label class="control-label">密码</label>

                                                        <div class="controls">

                                                            <input type="text" id="price" name="price" class="m-wrap medium">

                                                            <span id="priceMsg" class="help-inline"></span>

                                                        </div>

                                                    </div>

                                                    <div class="control-group">

                                                        <label class="control-label">电话</label>

                                                        <div class="controls">

                                                            <input type="text" id="price" name="price" class="m-wrap medium">

                                                            <span id="priceMsg" class="help-inline"></span>

                                                        </div>

                                                    </div>

                                                    <div class="control-group">

                                                        <label class="control-label">部门</label>

                                                        <div class="controls">

                                                            <select id="apiId" name="apiId" class="medium m-wrap" tabindex="1">

                                                                <#list apiList as api>

                                                                    <option value="${api.id}">${api.name}</option>

                                                                </#list>

                                                            </select>

                                                        </div>

                                                    </div>

                                                    <div class="control-group">

                                                        <label class="control-label">等级</label>

                                                        <div class="controls">

                                                            <select id="apiId" name="apiId" class="medium m-wrap" tabindex="1">

                                                                <#list apiList as api>

                                                                    <option value="${api.id}">${api.name}</option>

                                                                </#list>

                                                            </select>

                                                        </div>

                                                    </div>

                                                    <div class="control-group">

                                                        <label class="control-label">是否启用</label>

                                                        <div class="controls">

                                                            <select id="enabled" name="enabled" class="medium m-wrap" tabindex="1">

                                                                <option value="1">是</option>

                                                                <option value="0">否</option>

                                                            </select>

                                                        </div>

                                                    </div>

                                                </div>
                                            </div>

                                            <div class="form-actions">
                                                <button type="submit" class="btn blue"><i class="icon-ok"></i> Save</button>
                                                <button type="button" class="btn">Cancel</button>
                                            </div>

                                        </form>

                                        <!-- END FORM-->

                                    </div>

                                </div>

                            </div>

                        </div>

                    </div>

                    <!-- END SAMPLE FORM PORTLET-->

                </div>

            </div>

            <!-- END PAGE CONTENT-->

        </div>

        <!-- END PAGE CONTAINER-->

    </div>


    <#elseif section = "footer">

    </#if>
</@layout>