<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

    <meta charset="utf-8" />

    <title>Metronic | Data Tables - Managed Tables</title>

    <meta content="width=device-width, initial-scale=1.0" name="viewport" />

    <meta content="" name="description" />

    <meta content="" name="author" />

    <!-- BEGIN GLOBAL MANDATORY STYLES -->

    <link href="media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

    <link href="media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>

    <link href="media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

    <link href="media/css/style-metro.css" rel="stylesheet" type="text/css"/>

    <link href="media/css/style.css" rel="stylesheet" type="text/css"/>

    <link href="media/css/style-responsive.css" rel="stylesheet" type="text/css"/>

    <link href="media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>

    <link href="media/css/uniform.default.css" rel="stylesheet" type="text/css"/>

    <!-- END GLOBAL MANDATORY STYLES -->

    <!-- BEGIN PAGE LEVEL STYLES -->

    <link rel="stylesheet" type="text/css" href="media/css/select2_metro.css" />

    <link rel="stylesheet" href="media/css/DT_bootstrap.css" />

    <!-- END PAGE LEVEL STYLES -->

    <link rel="shortcut icon" href="media/image/favicon.ico" />

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="page-header-fixed">

<!-- BEGIN HEADER -->


<!-- END HEADER -->

<!-- BEGIN CONTAINER -->

<div class="page-container row-fluid">

    <!-- BEGIN SIDEBAR -->



    <!-- END SIDEBAR -->

    <!-- BEGIN PAGE -->

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

                    <!-- BEGIN PAGE TITLE & BREADCRUMB-->

                    <h3 class="page-title">

                        Managed Tables <small>managed table samples</small>

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

                        <li><a href="#">Managed Tables</a></li>

                    </ul>

                    <!-- END PAGE TITLE & BREADCRUMB-->

                </div>

            </div>

            <!-- END PAGE HEADER-->

            <!-- BEGIN PAGE CONTENT-->

            <div class="row-fluid">

                <div class="span12">

                    <!-- BEGIN EXAMPLE TABLE PORTLET-->

                    <div class="portlet box light-grey">

                        <div class="portlet-title">

                            <div class="caption"><i class="icon-globe"></i>Managed Table</div>

                            <div class="tools">

                                <a href="javascript:;" class="collapse"></a>

                                <a href="#portlet-config" data-toggle="modal" class="config"></a>

                                <a href="javascript:;" class="reload"></a>

                                <a href="javascript:;" class="remove"></a>

                            </div>

                        </div>

                        <div class="portlet-body">

                            <div class="clearfix">

                                <div class="btn-group">

                                    <button id="sample_editable_1_new" class="btn green">

                                        Add New <i class="icon-plus"></i>

                                    </button>

                                </div>

                                <div class="btn-group pull-right">

                                    <button class="btn dropdown-toggle" data-toggle="dropdown">Tools <i class="icon-angle-down"></i>

                                    </button>

                                    <ul class="dropdown-menu pull-right">

                                        <li><a href="#">Print</a></li>

                                        <li><a href="#">Save as PDF</a></li>

                                        <li><a href="#">Export to Excel</a></li>

                                    </ul>

                                </div>

                            </div>

                            <table class="table table-striped table-bordered table-hover" id="sample_1">

                                <thead>

                                <tr>

                                    <th style="width:8px;"><input type="checkbox" class="group-checkable" data-set="#sample_1 .checkboxes" /></th>

                                    <th>Username</th>

                                    <th class="hidden-480">Email</th>

                                    <th class="hidden-480">Points</th>

                                    <th class="hidden-480">Joined</th>

                                    <th ></th>

                                </tr>

                                </thead>

                                <tbody>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>shuxer</td>

                                    <td class="hidden-480"><a href="mailto:shuxer@gmail.com">shuxer@gmail.com</a></td>

                                    <td class="hidden-480">120</td>

                                    <td class="center hidden-480">12 Jan 2012</td>

                                    <td ><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>looper</td>

                                    <td class="hidden-480"><a href="mailto:looper90@gmail.com">looper90@gmail.com</a></td>

                                    <td class="hidden-480">120</td>

                                    <td class="center hidden-480">12.12.2011</td>

                                    <td ><span class="label label-warning">Suspended</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>userwow</td>

                                    <td class="hidden-480"><a href="mailto:userwow@yahoo.com">userwow@yahoo.com</a></td>

                                    <td class="hidden-480">20</td>

                                    <td class="center hidden-480">12.12.2012</td>

                                    <td ><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>user1wow</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">userwow@gmail.com</a></td>

                                    <td class="hidden-480">20</td>

                                    <td class="center hidden-480">12.12.2012</td>

                                    <td ><span class="label label-inverse">Blocked</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>restest</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">test@gmail.com</a></td>

                                    <td class="hidden-480">20</td>

                                    <td class="center hidden-480">12.12.2012</td>

                                    <td ><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>foopl</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>

                                    <td class="hidden-480">20</td>

                                    <td class="center hidden-480">19.11.2010</td>

                                    <td ><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>weep</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>

                                    <td class="hidden-480">20</td>

                                    <td class="center hidden-480">19.11.2010</td>

                                    <td ><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>coop</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>

                                    <td class="hidden-480">20</td>

                                    <td class="center hidden-480">19.11.2010</td>

                                    <td ><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>pppol</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>

                                    <td class="hidden-480">20</td>

                                    <td class="center hidden-480">19.11.2010</td>

                                    <td ><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>test</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>

                                    <td class="hidden-480">20</td>

                                    <td class="center hidden-480">19.11.2010</td>

                                    <td ><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>userwow</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">userwow@gmail.com</a></td>

                                    <td class="hidden-480">20</td>

                                    <td class="center hidden-480">12.12.2012</td>

                                    <td ><span class="label label-inverse">Blocked</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>test</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">test@gmail.com</a></td>

                                    <td class="hidden-480">20</td>

                                    <td class="center hidden-480">12.12.2012</td>

                                    <td ><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>goop</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>

                                    <td class="hidden-480">20</td>

                                    <td class="center hidden-480">12.11.2010</td>

                                    <td ><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>weep</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>

                                    <td class="hidden-480">20</td>

                                    <td class="center hidden-480">15.11.2011</td>

                                    <td ><span class="label label-inverse">Blocked</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>toopl</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>

                                    <td class="hidden-480">20</td>

                                    <td class="center hidden-480">16.11.2010</td>

                                    <td ><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>userwow</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">userwow@gmail.com</a></td>

                                    <td class="hidden-480">20</td>

                                    <td class="center hidden-480">9.12.2012</td>

                                    <td ><span class="label label-inverse">Blocked</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>tes21t</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">test@gmail.com</a></td>

                                    <td class="hidden-480">20</td>

                                    <td class="center hidden-480">14.12.2012</td>

                                    <td ><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>fop</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>

                                    <td class="hidden-480">20</td>

                                    <td class="center hidden-480">13.11.2010</td>

                                    <td ><span class="label label-warning">Suspended</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>kop</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>

                                    <td class="hidden-480">20</td>

                                    <td class="center hidden-480">17.11.2010</td>

                                    <td><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>vopl</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>

                                    <td class="hidden-480">20</td>

                                    <td class="center hidden-480">19.11.2010</td>

                                    <td><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>userwow</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">userwow@gmail.com</a></td>

                                    <td class="hidden-480">20</td>

                                    <td class="center hidden-480">12.12.2012</td>

                                    <td><span class="label label-inverse">Blocked</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>wap</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">test@gmail.com</a></td>

                                    <td class="hidden-480">20</td>

                                    <td class="center hidden-480">12.12.2012</td>

                                    <td><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>test</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>

                                    <td class="hidden-480">20</td>

                                    <td class="center hidden-480">19.12.2010</td>

                                    <td><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>toop</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>

                                    <td class="hidden-480">20</td>

                                    <td class="center hidden-480">17.12.2010</td>

                                    <td><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>weep</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>

                                    <td class="hidden-480">20</td>

                                    <td class="center hidden-480">15.11.2011</td>

                                    <td><span class="label label-success">Approved</span></td>

                                </tr>

                                </tbody>

                            </table>

                        </div>

                    </div>

                    <!-- END EXAMPLE TABLE PORTLET-->

                </div>

            </div>

            <div class="row-fluid">

                <div class="span6 responsive" data-tablet="span12 fix-offset" data-desktop="span6">

                    <!-- BEGIN EXAMPLE TABLE PORTLET-->

                    <div class="portlet box grey">

                        <div class="portlet-title">

                            <div class="caption"><i class="icon-user"></i>Table</div>

                            <div class="actions">

                                <a href="#" class="btn blue"><i class="icon-pencil"></i> Add</a>

                                <div class="btn-group">

                                    <a class="btn green" href="#" data-toggle="dropdown">

                                        <i class="icon-cogs"></i> Tools

                                        <i class="icon-angle-down"></i>

                                    </a>

                                    <ul class="dropdown-menu pull-right">

                                        <li><a href="#"><i class="icon-pencil"></i> Edit</a></li>

                                        <li><a href="#"><i class="icon-trash"></i> Delete</a></li>

                                        <li><a href="#"><i class="icon-ban-circle"></i> Ban</a></li>

                                        <li class="divider"></li>

                                        <li><a href="#"><i class="i"></i> Make admin</a></li>

                                    </ul>

                                </div>

                            </div>

                        </div>

                        <div class="portlet-body">

                            <table class="table table-striped table-bordered table-hover" id="sample_2">

                                <thead>

                                <tr>

                                    <th style="width:8px;"><input type="checkbox" class="group-checkable" data-set="#sample_2 .checkboxes" /></th>

                                    <th>Username</th>

                                    <th class="hidden-480">Email</th>

                                    <th class="hidden-480">Status</th>

                                </tr>

                                </thead>

                                <tbody>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>shuxer</td>

                                    <td class="hidden-480"><a href="mailto:shuxer@gmail.com">shuxer@gmail.com</a></td>

                                    <td><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>looper</td>

                                    <td class="hidden-480"><a href="mailto:looper90@gmail.com">looper90@gmail.com</a></td>

                                    <td><span class="label label-warning">Suspended</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>userwow</td>

                                    <td class="hidden-480"><a href="mailto:userwow@yahoo.com">userwow@yahoo.com</a></td>

                                    <td><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>user1wow</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">userwow@gmail.com</a></td>

                                    <td><span class="label label-inverse">Blocked</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>restest</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">test@gmail.com</a></td>

                                    <td><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>foopl</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>

                                    <td><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>weep</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>

                                    <td><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>coop</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>

                                    <td><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>pppol</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>

                                    <td><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>test</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>

                                    <td><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>userwow</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">userwow@gmail.com</a></td>

                                    <td><span class="label label-inverse">Blocked</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>test</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">test@gmail.com</a></td>

                                    <td><span class="label label-success">Approved</span></td>

                                </tr>

                                </tbody>

                            </table>

                        </div>

                    </div>

                    <!-- END EXAMPLE TABLE PORTLET-->

                </div>

                <div class="span6 responsive" data-tablet="span12 fix-offset" data-desktop="span6">

                    <!-- BEGIN EXAMPLE TABLE PORTLET-->

                    <div class="portlet box purple">

                        <div class="portlet-title">

                            <div class="caption"><i class="icon-cogs"></i>Table</div>

                            <div class="actions">

                                <a href="#" class="btn green"><i class="icon-plus"></i> Add</a>

                                <a href="#" class="btn yellow"><i class="icon-print"></i> Print</a>

                            </div>

                        </div>

                        <div class="portlet-body">

                            <table class="table table-striped table-bordered table-hover" id="sample_3">

                                <thead>

                                <tr>

                                    <th style="width:8px;"><input type="checkbox" class="group-checkable" data-set="#sample_3 .checkboxes" /></th>

                                    <th>Username</th>

                                    <th class="hidden-480">Email</th>

                                    <th class="hidden-480">Status</th>

                                </tr>

                                </thead>

                                <tbody>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>shuxer</td>

                                    <td class="hidden-480"><a href="mailto:shuxer@gmail.com">shuxer@gmail.com</a></td>

                                    <td><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>looper</td>

                                    <td class="hidden-480"><a href="mailto:looper90@gmail.com">looper90@gmail.com</a></td>

                                    <td><span class="label label-warning">Suspended</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>userwow</td>

                                    <td class="hidden-480"><a href="mailto:userwow@yahoo.com">userwow@yahoo.com</a></td>

                                    <td><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>user1wow</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">userwow@gmail.com</a></td>

                                    <td><span class="label label-inverse">Blocked</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>restest</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">test@gmail.com</a></td>

                                    <td><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>foopl</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>

                                    <td><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>weep</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>

                                    <td><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>coop</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>

                                    <td><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>pppol</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>

                                    <td><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>test</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>

                                    <td><span class="label label-success">Approved</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>userwow</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">userwow@gmail.com</a></td>

                                    <td><span class="label label-inverse">Blocked</span></td>

                                </tr>

                                <tr class="odd gradeX">

                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>

                                    <td>test</td>

                                    <td class="hidden-480"><a href="mailto:userwow@gmail.com">test@gmail.com</a></td>

                                    <td><span class="label label-success">Approved</span></td>

                                </tr>

                                </tbody>

                            </table>

                        </div>

                    </div>

                    <!-- END EXAMPLE TABLE PORTLET-->

                </div>

            </div>

            <!-- END PAGE CONTENT-->

        </div>

        <!-- END PAGE CONTAINER-->

    </div>

    <!-- END PAGE -->

</div>

<!-- END CONTAINER -->

<!-- BEGIN FOOTER -->



<!-- END FOOTER -->



</body>

<!-- END BODY -->

</html>