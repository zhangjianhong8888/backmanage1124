
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

                            <a href="index.html">首页</a>

                            <i class="icon-angle-right"></i>

                        </li>

                        <li>

                            <a href="#">客户管理</a>

                            <i class="icon-angle-right"></i>

                        </li>

                        <li><a href="#">客户列表</a></li>

                    </ul>

                    <!-- END PAGE TITLE & BREADCRUMB-->

                </div>

            </div>

            <div class="row-fluid">

                <div class="span12">

                    <div class="portlet box blue">

                        <div class="portlet-title">

                            <div class="caption"><i class="icon-cogs"></i>No More Tables</div>

                            <div class="tools">

                                <a href="javascript:;" class="collapse"></a>

                                <a href="#portlet-config" data-toggle="modal" class="config"></a>

                                <a href="javascript:;" class="reload"></a>

                                <a href="javascript:;" class="remove"></a>

                            </div>

                        </div>

                        <div class="portlet-body no-more-tables">

                            <table class="table-bordered table-striped table-condensed cf">

                                <thead class="cf">

                                <tr>

                                    <th>Code</th>

                                    <th>Company</th>

                                    <th class="numeric">Price</th>

                                    <th class="numeric">Change</th>

                                    <th class="numeric">Change %</th>

                                    <th class="numeric">Open</th>

                                    <th class="numeric">High</th>

                                    <th class="numeric">Low</th>

                                    <th class="numeric">Volume</th>

                                </tr>

                                </thead>

                                <tbody>

                                <tr>

                                    <td data-title="Code">AAC</td>

                                    <td data-title="Company">AUSTRALIAN AGRICULTURAL COMPANY LIMITED.</td>

                                    <td data-title="Price" class="numeric">$1.38</td>

                                    <td data-title="Change" class="numeric">-0.01</td>

                                    <td data-title="Change %" class="numeric">-0.36%</td>

                                    <td data-title="Open" class="numeric">$1.39</td>

                                    <td data-title="High" class="numeric">$1.39</td>

                                    <td data-title="Low" class="numeric">$1.38</td>

                                    <td data-title="Volume" class="numeric">9,395</td>

                                </tr>

                                <tr>

                                    <td data-title="Code">AAD</td>

                                    <td data-title="Company">ARDENT LEISURE GROUP</td>

                                    <td data-title="Price" class="numeric">$1.15</td>

                                    <td data-title="Change" class="numeric">  +0.02</td>

                                    <td data-title="Change %" class="numeric">1.32%</td>

                                    <td data-title="Open" class="numeric">$1.14</td>

                                    <td data-title="High" class="numeric">$1.15</td>

                                    <td data-title="Low" class="numeric">$1.13</td>

                                    <td data-title="Volume" class="numeric">56,431</td>

                                </tr>

                                <tr>

                                    <td data-title="Code">AAX</td>

                                    <td data-title="Company">AUSENCO LIMITED</td>

                                    <td data-title="Price" class="numeric">$4.00</td>

                                    <td data-title="Change" class="numeric">-0.04</td>

                                    <td data-title="Change %" class="numeric">-0.99%</td>

                                    <td data-title="Open" class="numeric">$4.01</td>

                                    <td data-title="High" class="numeric">$4.05</td>

                                    <td data-title="Low" class="numeric">$4.00</td>

                                    <td data-title="Volume" class="numeric">90,641</td>

                                </tr>


                                </tbody>

                            </table>

                            <div class="row-fluid">

                                <div class="span6">

                                    <div class="dataTables_info" id="sample_1_info">当前显示第 1 页 共 25 页</div>
                                </div>

                                <div class="span6">

                                    <div class="dataTables_paginate paging_bootstrap pagination">
                                        <ul>

                                            <li class="next"><a href="#"><span class="hidden-480">首页</span></a></li>

                                            <li class="next"><a href="#"><span class="hidden-480">上一页</span></a></li>

                                            <li class="next"><a href="#"><span class="hidden-480">下一页</span></a></li>

                                            <li class="next"><a href="#"><span class="hidden-480">尾页</span></a></li>

                                        </ul>

                                    </div>

                                </div>

                            </div>

                        </div>


                    </div>

                </div>

            </div>

        </div>

    </div>


    <#elseif section = "footer">

    </#if>
</@layout>