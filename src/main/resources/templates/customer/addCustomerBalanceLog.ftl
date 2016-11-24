
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

                                    <li><a href="#portlet_tab3" data-toggle="tab">Inline</a></li>

                                    <li><a href="#portlet_tab2" data-toggle="tab">Grid</a></li>

                                    <li class="active"><a href="#portlet_tab1" data-toggle="tab">Default</a></li>

                                </ul>

                                <div class="tab-content">

                                    <div class="tab-pane active" id="portlet_tab1">

                                        <!-- BEGIN FORM-->

                                        <form action="/customer/#" class="form-horizontal" method="post">

                                            <div class="control-group">

                                                <label class="control-label">Meduam Input</label>

                                                <div class="controls">

                                                    <input type="text" placeholder="medium" class="m-wrap medium">

                                                    <span class="help-inline">Some hint here</span>

                                                </div>

                                            </div>

                                            <div class="control-group">

                                                <label class="control-label">Meduam Input</label>

                                                <div class="controls">

                                                    <input type="text" placeholder="medium" class="m-wrap medium">

                                                    <span class="help-inline">Some hint here</span>

                                                </div>

                                            </div>

                                            <div class="control-group">

                                                <label class="control-label">Medium Dropdown</label>

                                                <div class="controls">

                                                    <select class="medium m-wrap" tabindex="1">

                                                        <option value="Category 1">Category 1</option>

                                                        <option value="Category 2">Category 2</option>

                                                        <option value="Category 3">Category 5</option>

                                                        <option value="Category 4">Category 4</option>

                                                    </select>

                                                </div>

                                            </div>

                                            <div class="form-actions">
                                                <button type="submit" class="btn blue"><i class="icon-ok"></i> Save</button>
                                                <button type="button" class="btn">Cancel</button>
                                            </div>

                                        </form>

                                        <!-- END FORM-->

                                    </div>

                                    <div class="tab-pane " id="portlet_tab2">

                                        <form>

                                            <div class="controls controls-row">

                                                <input class="span12 m-wrap" type="text" placeholder=".span12" />

                                            </div>

                                            <div class="controls controls-row">

                                                <input class="span11 m-wrap" type="text" placeholder=".span11" />

                                                <input class="span1 m-wrap" type="text" placeholder=".span1" />

                                            </div>

                                            <div class="controls controls-row">

                                                <input class="span10 m-wrap" type="text" placeholder=".span10" />

                                                <input class="span2 m-wrap" type="text" placeholder=".span2" />

                                            </div>

                                            <div class="controls controls-row">

                                                <input class="span9 m-wrap" type="text" placeholder=".span9" />

                                                <input class="span3 m-wrap" type="text" placeholder=".span3" />

                                            </div>

                                            <div class="controls controls-row">

                                                <input class="span8 m-wrap" type="text" placeholder=".span8" />

                                                <input class="span4 m-wrap" type="text" placeholder=".span4" />

                                            </div>

                                            <div class="controls controls-row">

                                                <input class="span7 m-wrap" type="text" placeholder=".span7" />

                                                <input class="span5 m-wrap" type="text" placeholder=".span5" />

                                            </div>

                                            <div class="controls controls-row">

                                                <input class="span6 m-wrap" type="text" placeholder=".span6" />

                                                <input class="span6 m-wrap" type="text" placeholder=".span6" />

                                            </div>

                                            <div class="controls controls-row">

                                                <input class="span5 m-wrap" type="text" placeholder=".span5" />

                                                <input class="span7 m-wrap" type="text" placeholder=".span7" />

                                            </div>

                                            <div class="controls controls-row">

                                                <input class="span4 m-wrap" type="text" placeholder=".span4" />

                                                <input class="span8 m-wrap" type="text" placeholder=".span8" />

                                            </div>

                                            <div class="controls controls-row">

                                                <input class="span3 m-wrap" type="text" placeholder=".span3" />

                                                <input class="span9 m-wrap" type="text" placeholder=".span9" />

                                            </div>

                                            <div class="controls controls-row">

                                                <input class="span2 m-wrap" type="text" placeholder=".span2" />

                                                <input class="span10 m-wrap" type="text" placeholder=".span10" />

                                            </div>

                                            <div class="controls controls-row">

                                                <input class="span1 m-wrap" type="text" placeholder=".span1" />

                                                <input class="span11 m-wrap" type="text" placeholder=".span11" />

                                            </div>

                                            <div class="controls controls-row">

                                                <input class="span2 m-wrap" type="text" placeholder=".span2" />

                                                <input class="span3 m-wrap" type="text" placeholder=".span3" />

                                                <input class="span4 m-wrap" type="text" placeholder=".span4" />

                                                <input class="span2 m-wrap" type="text" placeholder=".span2" />

                                                <input class="span1 m-wrap" type="text" placeholder=".span1" />

                                            </div>

                                        </form>

                                    </div>

                                    <div class="tab-pane " id="portlet_tab3">

                                        <h4>Login Form</h4>

                                        <form action="#">

                                            <input type="text" class="m-wrap" placeholder="Email" /><br />

                                            <input type="password" class="m-wrap" placeholder="Password" />

                                            <label class="checkbox">

                                                <input type="checkbox" /> Remember me

                                            </label>

                                            <button type="submit" class="btn green">Sign in</button>

                                        </form>

                                        <hr />

                                        <h4>Login Form</h4>

                                        <form action="#">

                                            <div class="input-icon left">

                                                <i class="icon-envelope"></i>

                                                <input type="text" class="m-wrap" placeholder="Email" />

                                            </div>

                                            <div class="input-icon left">

                                                <i class="icon-lock"></i>

                                                <input type="password" class="m-wrap" placeholder="Password" />

                                            </div>

                                            <label class="checkbox">

                                                <input type="checkbox" /> Remember me

                                            </label>

                                            <button type="submit" class="btn purple">Sign in</button>

                                        </form>

                                        <hr />

                                        <form action="#">

                                            <div class="input-prepend">

                                                <button class="btn blue">Login</button><input class="m-wrap" size="16" type="password" placeholder="Your Password" />

                                            </div>

                                        </form>

                                        <h4>Search Form</h4>

                                        <form action="#">

                                            <div class="input-append hidden-phone">

                                                <input class="m-wrap medium" size="10" type="text" placeholder="Twitter Username" /><button class="btn red">Search</button><button class="btn black">Back</button>

                                            </div>

                                            <div class="input-append visible-phone">

                                                <input class="m-wrap" size="10" type="text" placeholder="Twitter Username" /><button class="btn red">Search</button><button class="btn black">Back</button>

                                            </div>

                                        </form>

                                        <hr />

                                        <form action="#" class="form-search">

                                            <div class="input-append">

                                                <input class="m-wrap" type="text" /><button class="btn green" type="button">Search!</button>

                                            </div>

                                        </form>

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