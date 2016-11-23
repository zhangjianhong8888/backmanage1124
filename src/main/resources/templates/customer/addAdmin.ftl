<#include "layout.ftl">

<@layout ; section>
    <#if section = "head">

    <#elseif section = "content" >

    <div class="page-content">

        <div id="portlet-config" class="modal hide">

            <div class="modal-header">

                <button data-dismiss="modal" class="close" type="button"></button>

                <h3>portlet Settings</h3>

            </div>

            <div class="modal-body">

                <p>Here will be a configuration form</p>

            </div>

        </div>

        <div class="container-fluid">

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

                    <!-- BEGIN PAGE TITLE & BREADCRUMB-->

                    <h3 class="page-title">

                        Responsive Tables <small>responsive table samples</small>

                    </h3>

                    <ul class="breadcrumb">

                        <li>

                            <i class="icon-home"></i>

                            <a href="index.html">Home</a>

                            <i class="icon-angle-right"></i>

                        </li>

                        <li>

                            <a href="#">Data Tables</a>

                            <i class="icon-angle-right"></i>

                        </li>

                        <li><a href="#">Responsive Tables</a></li>

                    </ul>

                    <!-- END PAGE TITLE & BREADCRUMB-->

                </div>

            </div>

            <div class="row-fluid">

                <div class="span12">

                    <!-- BEGIN VALIDATION STATES-->

                    <div class="portlet box purple">

                        <div class="portlet-title">

                            <div class="caption"><i class="icon-reorder"></i>Basic Validation</div>

                            <div class="tools">

                                <a href="javascript:;" class="collapse"></a>

                                <a href="#portlet-config" data-toggle="modal" class="config"></a>

                                <a href="javascript:;" class="reload"></a>

                                <a href="javascript:;" class="remove"></a>

                            </div>

                        </div>

                        <div class="portlet-body form">

                            <!-- BEGIN FORM-->

                            <form action="#" id="form_sample_1" class="form-horizontal">

                                <div class="alert alert-error hide">

                                    <button class="close" data-dismiss="alert"></button>

                                    You have some form errors. Please check below.

                                </div>

                                <div class="alert alert-success hide">

                                    <button class="close" data-dismiss="alert"></button>

                                    Your form validation is successful!

                                </div>

                                <div class="control-group">

                                    <label class="control-label">Name<span class="required">*</span></label>

                                    <div class="controls">

                                        <input type="text" name="name" data-required="1" class="span6 m-wrap"/>

                                    </div>

                                </div>

                                <div class="control-group">

                                    <label class="control-label">Email<span class="required">*</span></label>

                                    <div class="controls">

                                        <input name="email" type="text" class="span6 m-wrap"/>

                                    </div>

                                </div>

                                <div class="control-group">

                                    <label class="control-label">URL<span class="required">*</span></label>

                                    <div class="controls">

                                        <input name="url" type="text" class="span6 m-wrap"/>

                                        <span class="help-block">e.g: http://www.demo.com or http://demo.com</span>

                                    </div>

                                </div>

                                <div class="control-group">

                                    <label class="control-label">Number<span class="required">*</span></label>

                                    <div class="controls">

                                        <input name="number" type="text" class="span6 m-wrap"/>

                                    </div>

                                </div>

                                <div class="control-group">

                                    <label class="control-label">Digits<span class="required">*</span></label>

                                    <div class="controls">

                                        <input name="digits" type="text" class="span6 m-wrap"/>

                                    </div>

                                </div>

                                <div class="control-group">

                                    <label class="control-label">Credit Card<span class="required">*</span></label>

                                    <div class="controls">

                                        <input name="creditcard" type="text" class="span6 m-wrap"/>

                                        <span class="help-block">e.g: 5500 0000 0000 0004</span>

                                    </div>

                                </div>

                                <div class="control-group">

                                    <label class="control-label">Occupation&nbsp;&nbsp;</label>

                                    <div class="controls">

                                        <input name="occupation" type="text" class="span6 m-wrap"/>

                                        <span class="help-block">optional field</span>

                                    </div>

                                </div>

                                <div class="control-group">

                                    <label class="control-label">Category<span class="required">*</span></label>

                                    <div class="controls">

                                        <select class="span6 m-wrap" name="category">

                                            <option value="">Select...</option>

                                            <option value="Category 1">Category 1</option>

                                            <option value="Category 2">Category 2</option>

                                            <option value="Category 3">Category 5</option>

                                            <option value="Category 4">Category 4</option>

                                        </select>

                                    </div>

                                </div>

                                <div class="form-actions">

                                    <button type="submit" class="btn purple">Validate</button>

                                    <button type="button" class="btn">Cancel</button>

                                </div>

                            </form>

                            <!-- END FORM-->

                        </div>

                    </div>

                    <!-- END VALIDATION STATES-->

                </div>

            </div>

        </div>

    </div>

    <#elseif section = "footer">

    </#if>
</@layout>