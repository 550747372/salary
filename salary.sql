create table gross_pay
(
    id                         bigint auto_increment
        primary key,
    staffCode                  varchar(256)                       null comment '唯一标识',
    companyCode                varchar(256)                       null comment '单位编码',
    companyName                varchar(256)                       null comment '单位名称',
    staffName                  varchar(256)                       null comment '姓名',
    idNumber                   varchar(256)                       null comment '身份证号',
    basePay                    varchar(256)                       null comment '基本工资',
    position                   varchar(256)                       null comment '职务（职级技术等级）',
    payLevel                   varchar(256)                       null comment '工资级别（岗位）',
    levelPay                   varchar(256)                       null comment '级别（岗位）工资',
    remarkA                    varchar(256)                       null comment '保留字段1',
    remarkB                    varchar(256)                       null comment '保留字段2',
    subsidyTag                 varchar(256)                       null comment '津、补贴小记',
    workSubsidy                varchar(256)                       null comment '工作性津贴',
    liveSubsidy                varchar(256)                       null comment '生活性补贴',
    workAdjustSubsidy          varchar(256)                       null comment '工改保留补贴',
    governmentSubsidy          varchar(256)                       null comment '在京中央国家机关补贴',
    phoneSubsidy               varchar(256)                       null comment '住宅公务电话包干费',
    nannySubsidy               varchar(256)                       null comment '高级干部保姆自雇费',
    onlyChildSubsidy           varchar(256)                       null comment '独生子女奖励',
    babySubsidy                varchar(256)                       null comment '婴幼儿补贴',
    visitsSubsidy              varchar(256)                       null comment '信访岗位津贴',
    minorityNationalitySubsidy varchar(256)                       null comment '少数民族津贴',
    remarkC                    varchar(256)                       null comment '保留字段3',
    remarkD                    varchar(256)                       null comment '保留字段4',
    remarkE                    varchar(256)                       null comment '保留字段5',
    totalGrossPay              varchar(256)                       null comment '应发合计',
    subsidyPay                 varchar(256)                       null comment '补发工资',
    totalDeductions            varchar(256)                       null comment '代扣合计',
    housingProvidentFund       varchar(256)                       null comment '住房公积金',
    individualIncomeTax        varchar(256)                       null comment '个人所得税',
    pensionInsurance           varchar(256)                       null comment '基本养老保险个人缴费',
    annuity                    varchar(256)                       null comment '职业年金个人缴费',
    adjustedPay                varchar(256)                       null comment '补扣工资',
    totalNetPay                varchar(256)                       null comment '实发合计',
    positionPay                varchar(256)                       null comment '职务（职级技术等级）工资',
    year                       int      default 0                 not null comment '年',
    month                      int      default 0                 not null comment '月',
    create_time                datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time                datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
);

create index gross_pay_staffCode_year_month_index
    on gross_pay (staffCode, year, month);


create table net_pay
(
    id                           int auto_increment
        primary key,
    staffCode                    varchar(256)                       null comment '唯一标识',
    totalNum                     varchar(256)                       null comment '总序号',
    num                          varchar(256)                       null comment '序号',
    deptName                     varchar(256)                       null comment '部门',
    company                      varchar(256)                       null comment '单位',
    staffName                    varchar(256)                       null comment '姓名',
    originPosition               varchar(256)                       null comment '原职务（级）',
    position                     varchar(256)                       null comment '现职务（级）',
    beginPayTime                 varchar(256)                       null comment '起薪（停薪）时间',
    phoneSubsidyBefore           varchar(256)                       null comment '变动前移动通讯补贴',
    specialPositionSubsidyBefore varchar(256)                       null comment '变动前特殊岗位通讯补贴',
    rentSubsidyBefore            varchar(256)                       null comment '变动前住房提租补贴',
    shuttleSubsidyBefore         varchar(256)                       null comment '变动前班车补贴',
    housingSubsidyBefore         varchar(256)                       null comment '变动前住房补贴',
    busSubsidyBefore             varchar(256)                       null comment '变动前公车补贴',
    propertySubsidyBefore        varchar(256)                       null comment '变动前物业补贴',
    phoneSubsidyAfter            varchar(256)                       null comment '变动后移动通讯补贴',
    specialPositionSubsidyAfter  varchar(256)                       null comment '变动后特殊岗位移动通讯补贴',
    rentSubsidyAfter             varchar(256)                       null comment '变动后住房提租补贴',
    shuttleSubsidyAfter          varchar(256)                       null comment '变动后班车补贴',
    housingSubsidyAfter          varchar(256)                       null comment '变动后住房补贴',
    busSubsidyAfter              varchar(256)                       null comment '变动后公车补贴',
    propertySubsidyAfter         varchar(256)                       null comment '变动后物业补贴',
    backPayMonth                 varchar(256)                       null comment '补发月数',
    backSubsidy                  varchar(256)                       null comment '补发津补贴额',
    phoneSubsidyDetail           varchar(256)                       null comment '移动通讯补贴明细',
    specialPositionSubsidyDetail varchar(256)                       null comment '特殊岗位移动通讯补明细',
    rentSubsidyDetail            varchar(256)                       null comment '住房提租补贴明细',
    shuttleSubsidyDetail         varchar(256)                       null comment '班车补贴明细',
    housingSubsidyDetail         varchar(256)                       null comment '住房补贴明细',
    busSubsidyDetail             varchar(256)                       null comment '公车补贴明细',
    propertySubsidyDetail        varchar(256)                       null comment '物业补贴明细',
    remark                       varchar(256)                       null comment '备注',
    backPay                      varchar(256)                       null comment '补发工资',
    deductedWages                varchar(256)                       null comment '补扣工资',
    grossPay                     varchar(256)                       null comment '应发工资',
    netPay                       varchar(256)                       null comment '实发工资',
    remarkA                      varchar(256)                       null comment '预留字段1',
    remarkB                      varchar(256)                       null comment '预留字段2',
    remarkC                      varchar(256)                       null comment '预留字段3',
    year                         int      default 0                 not null comment '年',
    month                        int      default 0                 not null comment '月',
    create_time                  datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time                  datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
);

create index net_pay_staffCode_year_month_index
    on net_pay (staffCode, year, month);


create table staff
(
    id          bigint auto_increment
        primary key,
    staffCode   varchar(256)                       null comment '唯一标识',
    password    varchar(256)                       null comment '密码',
    remark      varchar(256)                       null comment '备注',
    create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
);

create index net_pay_staffCode_year_month_index
    on staff (staffCode);


select AES_DECRYPT(unhex(password), unhex('5434d09c46abbf72cea979d95c29e0d5')) from staff;