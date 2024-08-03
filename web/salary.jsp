<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/7/23
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="div-tit-right">${dto.grossPay.month}月应发合计：<i>${dto.grossPay.totalGrossPay}</i>元，${dto.grossPay.month}月实发合计：<i>${dto.grossPay.totalNetPay}</i>元
</div>
<div class="tf-table">
    <table>
        <tr class="bgh-table">
            <th colspan="2">统发工资</th>
        </tr>
        <tr class="bg-table">
            <td colspan="2" class="f-color">基本工资：<em>￥</em><i>${dto.grossPay.basePay}</i></td>
        </tr>
        <tr>
            <td>职务（职级、技术等级）工资：<em>￥</em><i>${dto.grossPay.positionPay}</i></td>
            <td>级别（岗位）工资：<em>￥</em><i>${dto.grossPay.positionPay}</i></td>
        </tr>
        <tr class="bg-table">
            <td colspan="2" class="f-color">津、补贴小计：<em>￥</em><i>${dto.grossPay.subsidyTag}</i></td>
        </tr>
        <tr>
            <td>工作性津贴：<em>￥</em><i>${dto.grossPay.workSubsidy}</i></td>
            <td>高级干部保姆自雇费：<em>￥</em><i>${dto.grossPay.liveSubsidy}</i></td>
        </tr>
        <tr>
            <td>生活性补贴：<em>￥</em><i>${dto.grossPay.liveSubsidy}</i></td>
            <td>独生子女奖励：<em>￥</em><i>${dto.grossPay.onlyChildSubsidy}</i></td>
        </tr>
        <tr>
            <td>工改保留补贴：<em>￥</em><i>${dto.grossPay.workAdjustSubsidy}</i></td>
            <td>婴幼儿补贴：<em>￥</em><i>${dto.grossPay.babySubsidy}</i></td>
        </tr>
        <tr>
            <td>在京中央国家机关补贴：<em>￥</em><i>${dto.grossPay.governmentSubsidy}</i></td>
            <td>信访岗位津贴：<em>￥</em><i>${dto.grossPay.visitsSubsidy}</i></td>
        </tr>
        <tr>
            <td>住宅公务电话包干费：<em>￥</em><i>${dto.grossPay.phoneSubsidy}</i></td>
            <td>少数民族补贴：<em>￥</em><i>${dto.grossPay.minorityNationalitySubsidy}</i></td>
        </tr>
        <tr class="bg-table">
            <td colspan="2" class="f-color">本月应发：<em>￥</em><i>${dto.grossPay.totalGrossPay}</i></td>
        </tr>
        <tr class="bg-table">
            <td colspan="2" class="f-color">补发工资：<em>￥</em><i>${dto.grossPay.subsidyPay}</i></td>
        </tr>
        <tr class="bg-table">
            <td colspan="2" class="f-color">代扣合计：<em>￥</em><i>${dto.grossPay.totalDeductions}</i></td>
        </tr>
        <tr>
            <td>住房公积金：<em>￥</em><i>${dto.grossPay.housingProvidentFund}</i></td>
            <td>基本养老保险个人缴费：<em>￥</em><i>${dto.grossPay.pensionInsurance}</i></td>
        </tr>
        <tr>
            <td>个人所得税：<em>￥</em><i>${dto.grossPay.individualIncomeTax}</i></td>
            <td>职业年金个人缴费：<em>￥</em><i>${dto.grossPay.annuity}</i></td>
        </tr>
        <tr class="bg-table">
            <td colspan="2" class="f-color">补扣工资：<em>￥</em><i>${dto.grossPay.adjustedPay}</i></td>
        </tr>
        <tr class="bg-table" class="f-color">
            <td colspan="2" class="f-color">本月实发：<em>￥</em><i>${dto.grossPay.totalNetPay}</i></td>
        </tr>
    </table>
</div>
<div class="zf-table" style="margin-top: 20px;">
    <table>
        <tr class="bgh-table">
            <th colspan="2">自发工资</th>
        </tr>
        <tr class="bg-table">
            <td colspan="2" class="f-color">其他津贴</td>
        </tr>
        <tr>
            <td>移动通讯补贴：<em>￥</em><i>${dto.netPay.phoneSubsidyAfter}</i></td>
            <td>住房补贴：<em>￥</em><i>${dto.netPay.housingSubsidyAfter}</i></td>
        </tr>
        <tr>
            <td>特殊岗位移动通讯补贴：<em>￥</em><i>${dto.netPay.specialPositionSubsidyAfter}</i></td>
            <td>公车补贴：<em>￥</em><i>${dto.netPay.busSubsidyAfter}</i></td>
        </tr>
        <tr>
            <td>住房提租补贴：<em>￥</em><i>${dto.netPay.rentSubsidyAfter}</i></td>
            <td>物业补贴：<em>￥</em><i>${dto.netPay.propertySubsidyAfter}</i></td>
        </tr>
        <tr>
            <td>班车补贴：<em>￥</em><i>${dto.netPay.shuttleSubsidyAfter}</i></td>
            <td>字段一：<em>￥</em><i></i></td>
        </tr>
        <tr class="bg-table">
            <td colspan="2" class="f-color">补发工资：<em>￥</em><i>${dto.netPay.backPay}</i></td>
        </tr>
        <tr class="bg-table">
            <td colspan="2" class="f-color">补扣工资：<em>￥</em><i>${dto.netPay.deductedWages}</i></td>
        </tr>
        <tr class="bg-table">
            <td colspan="2" class="f-color">本月应发：<em>￥</em><i>${dto.netPay.grossPay}</i></td>
        </tr>
        <tr class="bg-table">
            <td colspan="2" class="f-color">本月实发：<em>￥</em><i>${dto.netPay.netPay}</i></td>
        </tr>
    </table>
</div>
