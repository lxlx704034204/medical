/*
Navicat MySQL Data Transfer

Source Server         : myLinuxdb
Source Server Version : 80012
Source Host           : 172.30.1.251:3306
Source Database       : medical

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2018-09-29 16:15:02
*/

CREATE DATABASE `medical`;
use medical;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `writer` varchar(50) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '12', '11', '1212');
INSERT INTO `book` VALUES ('4', '3343', '333', '333');
INSERT INTO `book` VALUES ('5', '44555', '454545', '4545454545');

-- ----------------------------
-- Table structure for t_control_param
-- ----------------------------
DROP TABLE IF EXISTS `t_control_param`;
CREATE TABLE `t_control_param` (
  `code` varchar(20) NOT NULL COMMENT '参数代码',
  `p_name` varchar(50) DEFAULT NULL COMMENT '参数名称',
  `p_type` varchar(50) DEFAULT NULL COMMENT '参数类型',
  `p_value` varchar(50) DEFAULT NULL COMMENT '参数值',
  `unit` varchar(10) DEFAULT NULL COMMENT '单位',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态1=有效，0=无效',
  `description` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(100) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(100) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`code`),
  KEY `idx_param_name` (`p_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='参数控制表';

-- ----------------------------
-- Records of t_control_param
-- ----------------------------

-- ----------------------------
-- Table structure for t_group
-- ----------------------------
DROP TABLE IF EXISTS `t_group`;
CREATE TABLE `t_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '组id',
  `parent_id` int(11) NOT NULL COMMENT '用户组父id',
  `name` varchar(200) DEFAULT NULL COMMENT '用户组名称',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态1=有效，0=无效',
  `description` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(100) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(100) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户组表';

-- ----------------------------
-- Records of t_group
-- ----------------------------

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `parent_id` int(11) NOT NULL COMMENT '父菜单id',
  `type` varchar(100) DEFAULT NULL COMMENT '菜单类型',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单路径',
  `icon` varchar(200) DEFAULT NULL COMMENT '菜单图标',
  `name` varchar(200) DEFAULT NULL COMMENT '菜单名称',
  `sort_number` int(11) DEFAULT NULL COMMENT '排序号码',
  `level_number` int(11) DEFAULT NULL COMMENT '层次号码',
  `is_visible` tinyint(1) DEFAULT NULL COMMENT '是否见',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态1=有效，0=无效',
  `description` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(100) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(100) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`),
  KEY `idx_parent_id` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单表';

-- ----------------------------
-- Records of t_menu
-- ----------------------------

-- ----------------------------
-- Table structure for t_message_type
-- ----------------------------
DROP TABLE IF EXISTS `t_message_type`;
CREATE TABLE `t_message_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `message_type` varchar(50) DEFAULT NULL COMMENT '类型名称',
  `status` smallint(6) DEFAULT '1' COMMENT '状态',
  `create_dt` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_message_type
-- ----------------------------

-- ----------------------------
-- Table structure for t_pca
-- ----------------------------
DROP TABLE IF EXISTS `t_pca`;
CREATE TABLE `t_pca` (
  `pca_code` varchar(12) NOT NULL COMMENT '行政区代码',
  `pca_name` varchar(80) DEFAULT NULL COMMENT '行政区名称',
  `pca_desc` varchar(100) DEFAULT NULL COMMENT '描述',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态1=有效，0=无效',
  PRIMARY KEY (`pca_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='行政区域表';

-- ----------------------------
-- Records of t_pca
-- ----------------------------
INSERT INTO `t_pca` VALUES ('110000', '北京市', null, '1');
INSERT INTO `t_pca` VALUES ('110101', '东城区', null, '1');
INSERT INTO `t_pca` VALUES ('110102', '西城区', null, '1');
INSERT INTO `t_pca` VALUES ('110105', '朝阳区', null, '1');
INSERT INTO `t_pca` VALUES ('110106', '丰台区', null, '1');
INSERT INTO `t_pca` VALUES ('110107', '石景山区', null, '1');
INSERT INTO `t_pca` VALUES ('110108', '海淀区', null, '1');
INSERT INTO `t_pca` VALUES ('110109', '门头沟区', null, '1');
INSERT INTO `t_pca` VALUES ('110111', '房山区', null, '1');
INSERT INTO `t_pca` VALUES ('110112', '通州区', null, '1');
INSERT INTO `t_pca` VALUES ('110113', '顺义区', null, '1');
INSERT INTO `t_pca` VALUES ('110114', '昌平区', null, '1');
INSERT INTO `t_pca` VALUES ('110115', '大兴区', null, '1');
INSERT INTO `t_pca` VALUES ('110116', '怀柔区', null, '1');
INSERT INTO `t_pca` VALUES ('110117', '平谷区', null, '1');
INSERT INTO `t_pca` VALUES ('110118', '密云区', null, '1');
INSERT INTO `t_pca` VALUES ('110119', '延庆区', null, '1');
INSERT INTO `t_pca` VALUES ('120000', '天津市', null, '1');
INSERT INTO `t_pca` VALUES ('120101', '和平区', null, '1');
INSERT INTO `t_pca` VALUES ('120102', '河东区', null, '1');
INSERT INTO `t_pca` VALUES ('120103', '河西区', null, '1');
INSERT INTO `t_pca` VALUES ('120104', '南开区', null, '1');
INSERT INTO `t_pca` VALUES ('120105', '河北区', null, '1');
INSERT INTO `t_pca` VALUES ('120106', '红桥区', null, '1');
INSERT INTO `t_pca` VALUES ('120110', '东丽区', null, '1');
INSERT INTO `t_pca` VALUES ('120111', '西青区', null, '1');
INSERT INTO `t_pca` VALUES ('120112', '津南区', null, '1');
INSERT INTO `t_pca` VALUES ('120113', '北辰区', null, '1');
INSERT INTO `t_pca` VALUES ('120114', '武清区', null, '1');
INSERT INTO `t_pca` VALUES ('120115', '宝坻区', null, '1');
INSERT INTO `t_pca` VALUES ('120116', '滨海新区', null, '1');
INSERT INTO `t_pca` VALUES ('120117', '宁河区', null, '1');
INSERT INTO `t_pca` VALUES ('120118', '静海区', null, '1');
INSERT INTO `t_pca` VALUES ('120119', '蓟州区', null, '1');
INSERT INTO `t_pca` VALUES ('130000', '河北省', null, '1');
INSERT INTO `t_pca` VALUES ('130100', '石家庄市', null, '1');
INSERT INTO `t_pca` VALUES ('130102', '长安区', null, '1');
INSERT INTO `t_pca` VALUES ('130104', '桥西区', null, '1');
INSERT INTO `t_pca` VALUES ('130105', '新华区', null, '1');
INSERT INTO `t_pca` VALUES ('130107', '井陉矿区', null, '1');
INSERT INTO `t_pca` VALUES ('130108', '裕华区', null, '1');
INSERT INTO `t_pca` VALUES ('130109', '藁城区', null, '1');
INSERT INTO `t_pca` VALUES ('130110', '鹿泉区', null, '1');
INSERT INTO `t_pca` VALUES ('130111', '栾城区', null, '1');
INSERT INTO `t_pca` VALUES ('130121', '井陉县', null, '1');
INSERT INTO `t_pca` VALUES ('130123', '正定县', null, '1');
INSERT INTO `t_pca` VALUES ('130125', '行唐县', null, '1');
INSERT INTO `t_pca` VALUES ('130126', '灵寿县', null, '1');
INSERT INTO `t_pca` VALUES ('130127', '高邑县', null, '1');
INSERT INTO `t_pca` VALUES ('130128', '深泽县', null, '1');
INSERT INTO `t_pca` VALUES ('130129', '赞皇县', null, '1');
INSERT INTO `t_pca` VALUES ('130130', '无极县', null, '1');
INSERT INTO `t_pca` VALUES ('130131', '平山县', null, '1');
INSERT INTO `t_pca` VALUES ('130132', '元氏县', null, '1');
INSERT INTO `t_pca` VALUES ('130133', '赵县', null, '1');
INSERT INTO `t_pca` VALUES ('130181', '辛集市', null, '1');
INSERT INTO `t_pca` VALUES ('130183', '晋州市', null, '1');
INSERT INTO `t_pca` VALUES ('130184', '新乐市', null, '1');
INSERT INTO `t_pca` VALUES ('130200', '唐山市', null, '1');
INSERT INTO `t_pca` VALUES ('130202', '路南区', null, '1');
INSERT INTO `t_pca` VALUES ('130203', '路北区', null, '1');
INSERT INTO `t_pca` VALUES ('130204', '古冶区', null, '1');
INSERT INTO `t_pca` VALUES ('130205', '开平区', null, '1');
INSERT INTO `t_pca` VALUES ('130207', '丰南区', null, '1');
INSERT INTO `t_pca` VALUES ('130208', '丰润区', null, '1');
INSERT INTO `t_pca` VALUES ('130209', '曹妃甸区', null, '1');
INSERT INTO `t_pca` VALUES ('130223', '滦县', null, '1');
INSERT INTO `t_pca` VALUES ('130224', '滦南县', null, '1');
INSERT INTO `t_pca` VALUES ('130225', '乐亭县', null, '1');
INSERT INTO `t_pca` VALUES ('130227', '迁西县', null, '1');
INSERT INTO `t_pca` VALUES ('130229', '玉田县', null, '1');
INSERT INTO `t_pca` VALUES ('130281', '遵化市', null, '1');
INSERT INTO `t_pca` VALUES ('130283', '迁安市', null, '1');
INSERT INTO `t_pca` VALUES ('130300', '秦皇岛市', null, '1');
INSERT INTO `t_pca` VALUES ('130302', '海港区', null, '1');
INSERT INTO `t_pca` VALUES ('130303', '山海关区', null, '1');
INSERT INTO `t_pca` VALUES ('130304', '北戴河区', null, '1');
INSERT INTO `t_pca` VALUES ('130306', '抚宁区', null, '1');
INSERT INTO `t_pca` VALUES ('130321', '青龙满族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('130322', '昌黎县', null, '1');
INSERT INTO `t_pca` VALUES ('130324', '卢龙县', null, '1');
INSERT INTO `t_pca` VALUES ('130400', '邯郸市', null, '1');
INSERT INTO `t_pca` VALUES ('130402', '邯山区', null, '1');
INSERT INTO `t_pca` VALUES ('130403', '丛台区', null, '1');
INSERT INTO `t_pca` VALUES ('130404', '复兴区', null, '1');
INSERT INTO `t_pca` VALUES ('130406', '峰峰矿区', null, '1');
INSERT INTO `t_pca` VALUES ('130407', '肥乡区', null, '1');
INSERT INTO `t_pca` VALUES ('130408', '永年区', null, '1');
INSERT INTO `t_pca` VALUES ('130423', '临漳县', null, '1');
INSERT INTO `t_pca` VALUES ('130424', '成安县', null, '1');
INSERT INTO `t_pca` VALUES ('130425', '大名县', null, '1');
INSERT INTO `t_pca` VALUES ('130426', '涉县', null, '1');
INSERT INTO `t_pca` VALUES ('130427', '磁县', null, '1');
INSERT INTO `t_pca` VALUES ('130430', '邱县', null, '1');
INSERT INTO `t_pca` VALUES ('130431', '鸡泽县', null, '1');
INSERT INTO `t_pca` VALUES ('130432', '广平县', null, '1');
INSERT INTO `t_pca` VALUES ('130433', '馆陶县', null, '1');
INSERT INTO `t_pca` VALUES ('130434', '魏县', null, '1');
INSERT INTO `t_pca` VALUES ('130435', '曲周县', null, '1');
INSERT INTO `t_pca` VALUES ('130481', '武安市', null, '1');
INSERT INTO `t_pca` VALUES ('130500', '邢台市', null, '1');
INSERT INTO `t_pca` VALUES ('130502', '桥东区', null, '1');
INSERT INTO `t_pca` VALUES ('130503', '桥西区', null, '1');
INSERT INTO `t_pca` VALUES ('130521', '邢台县', null, '1');
INSERT INTO `t_pca` VALUES ('130522', '临城县', null, '1');
INSERT INTO `t_pca` VALUES ('130523', '内丘县', null, '1');
INSERT INTO `t_pca` VALUES ('130524', '柏乡县', null, '1');
INSERT INTO `t_pca` VALUES ('130525', '隆尧县', null, '1');
INSERT INTO `t_pca` VALUES ('130526', '任县', null, '1');
INSERT INTO `t_pca` VALUES ('130527', '南和县', null, '1');
INSERT INTO `t_pca` VALUES ('130528', '宁晋县', null, '1');
INSERT INTO `t_pca` VALUES ('130529', '巨鹿县', null, '1');
INSERT INTO `t_pca` VALUES ('130530', '新河县', null, '1');
INSERT INTO `t_pca` VALUES ('130531', '广宗县', null, '1');
INSERT INTO `t_pca` VALUES ('130532', '平乡县', null, '1');
INSERT INTO `t_pca` VALUES ('130533', '威县', null, '1');
INSERT INTO `t_pca` VALUES ('130534', '清河县', null, '1');
INSERT INTO `t_pca` VALUES ('130535', '临西县', null, '1');
INSERT INTO `t_pca` VALUES ('130581', '南宫市', null, '1');
INSERT INTO `t_pca` VALUES ('130582', '沙河市', null, '1');
INSERT INTO `t_pca` VALUES ('130600', '保定市', null, '1');
INSERT INTO `t_pca` VALUES ('130602', '竞秀区', null, '1');
INSERT INTO `t_pca` VALUES ('130606', '莲池区', null, '1');
INSERT INTO `t_pca` VALUES ('130607', '满城区', null, '1');
INSERT INTO `t_pca` VALUES ('130608', '清苑区', null, '1');
INSERT INTO `t_pca` VALUES ('130609', '徐水区', null, '1');
INSERT INTO `t_pca` VALUES ('130623', '涞水县', null, '1');
INSERT INTO `t_pca` VALUES ('130624', '阜平县', null, '1');
INSERT INTO `t_pca` VALUES ('130626', '定兴县', null, '1');
INSERT INTO `t_pca` VALUES ('130627', '唐县', null, '1');
INSERT INTO `t_pca` VALUES ('130628', '高阳县', null, '1');
INSERT INTO `t_pca` VALUES ('130629', '容城县', null, '1');
INSERT INTO `t_pca` VALUES ('130630', '涞源县', null, '1');
INSERT INTO `t_pca` VALUES ('130631', '望都县', null, '1');
INSERT INTO `t_pca` VALUES ('130632', '安新县', null, '1');
INSERT INTO `t_pca` VALUES ('130633', '易县', null, '1');
INSERT INTO `t_pca` VALUES ('130634', '曲阳县', null, '1');
INSERT INTO `t_pca` VALUES ('130635', '蠡县', null, '1');
INSERT INTO `t_pca` VALUES ('130636', '顺平县', null, '1');
INSERT INTO `t_pca` VALUES ('130637', '博野县', null, '1');
INSERT INTO `t_pca` VALUES ('130638', '雄县', null, '1');
INSERT INTO `t_pca` VALUES ('130681', '涿州市', null, '1');
INSERT INTO `t_pca` VALUES ('130682', '定州市', null, '1');
INSERT INTO `t_pca` VALUES ('130683', '安国市', null, '1');
INSERT INTO `t_pca` VALUES ('130684', '高碑店市', null, '1');
INSERT INTO `t_pca` VALUES ('130700', '张家口市', null, '1');
INSERT INTO `t_pca` VALUES ('130702', '桥东区', null, '1');
INSERT INTO `t_pca` VALUES ('130703', '桥西区', null, '1');
INSERT INTO `t_pca` VALUES ('130705', '宣化区', null, '1');
INSERT INTO `t_pca` VALUES ('130706', '下花园区', null, '1');
INSERT INTO `t_pca` VALUES ('130708', '万全区', null, '1');
INSERT INTO `t_pca` VALUES ('130709', '崇礼区', null, '1');
INSERT INTO `t_pca` VALUES ('130722', '张北县', null, '1');
INSERT INTO `t_pca` VALUES ('130723', '康保县', null, '1');
INSERT INTO `t_pca` VALUES ('130724', '沽源县', null, '1');
INSERT INTO `t_pca` VALUES ('130725', '尚义县', null, '1');
INSERT INTO `t_pca` VALUES ('130726', '蔚县', null, '1');
INSERT INTO `t_pca` VALUES ('130727', '阳原县', null, '1');
INSERT INTO `t_pca` VALUES ('130728', '怀安县', null, '1');
INSERT INTO `t_pca` VALUES ('130730', '怀来县', null, '1');
INSERT INTO `t_pca` VALUES ('130731', '涿鹿县', null, '1');
INSERT INTO `t_pca` VALUES ('130732', '赤城县', null, '1');
INSERT INTO `t_pca` VALUES ('130800', '承德市', null, '1');
INSERT INTO `t_pca` VALUES ('130802', '双桥区', null, '1');
INSERT INTO `t_pca` VALUES ('130803', '双滦区', null, '1');
INSERT INTO `t_pca` VALUES ('130804', '鹰手营子矿区', null, '1');
INSERT INTO `t_pca` VALUES ('130821', '承德县', null, '1');
INSERT INTO `t_pca` VALUES ('130822', '兴隆县', null, '1');
INSERT INTO `t_pca` VALUES ('130824', '滦平县', null, '1');
INSERT INTO `t_pca` VALUES ('130825', '隆化县', null, '1');
INSERT INTO `t_pca` VALUES ('130826', '丰宁满族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('130827', '宽城满族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('130828', '围场满族蒙古族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('130881', '平泉市', null, '1');
INSERT INTO `t_pca` VALUES ('130900', '沧州市', null, '1');
INSERT INTO `t_pca` VALUES ('130902', '新华区', null, '1');
INSERT INTO `t_pca` VALUES ('130903', '运河区', null, '1');
INSERT INTO `t_pca` VALUES ('130921', '沧县', null, '1');
INSERT INTO `t_pca` VALUES ('130922', '青县', null, '1');
INSERT INTO `t_pca` VALUES ('130923', '东光县', null, '1');
INSERT INTO `t_pca` VALUES ('130924', '海兴县', null, '1');
INSERT INTO `t_pca` VALUES ('130925', '盐山县', null, '1');
INSERT INTO `t_pca` VALUES ('130926', '肃宁县', null, '1');
INSERT INTO `t_pca` VALUES ('130927', '南皮县', null, '1');
INSERT INTO `t_pca` VALUES ('130928', '吴桥县', null, '1');
INSERT INTO `t_pca` VALUES ('130929', '献县', null, '1');
INSERT INTO `t_pca` VALUES ('130930', '孟村回族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('130981', '泊头市', null, '1');
INSERT INTO `t_pca` VALUES ('130982', '任丘市', null, '1');
INSERT INTO `t_pca` VALUES ('130983', '黄骅市', null, '1');
INSERT INTO `t_pca` VALUES ('130984', '河间市', null, '1');
INSERT INTO `t_pca` VALUES ('131000', '廊坊市', null, '1');
INSERT INTO `t_pca` VALUES ('131002', '安次区', null, '1');
INSERT INTO `t_pca` VALUES ('131003', '广阳区', null, '1');
INSERT INTO `t_pca` VALUES ('131022', '固安县', null, '1');
INSERT INTO `t_pca` VALUES ('131023', '永清县', null, '1');
INSERT INTO `t_pca` VALUES ('131024', '香河县', null, '1');
INSERT INTO `t_pca` VALUES ('131025', '大城县', null, '1');
INSERT INTO `t_pca` VALUES ('131026', '文安县', null, '1');
INSERT INTO `t_pca` VALUES ('131028', '大厂回族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('131081', '霸州市', null, '1');
INSERT INTO `t_pca` VALUES ('131082', '三河市', null, '1');
INSERT INTO `t_pca` VALUES ('131100', '衡水市', null, '1');
INSERT INTO `t_pca` VALUES ('131102', '桃城区', null, '1');
INSERT INTO `t_pca` VALUES ('131103', '冀州区', null, '1');
INSERT INTO `t_pca` VALUES ('131121', '枣强县', null, '1');
INSERT INTO `t_pca` VALUES ('131122', '武邑县', null, '1');
INSERT INTO `t_pca` VALUES ('131123', '武强县', null, '1');
INSERT INTO `t_pca` VALUES ('131124', '饶阳县', null, '1');
INSERT INTO `t_pca` VALUES ('131125', '安平县', null, '1');
INSERT INTO `t_pca` VALUES ('131126', '故城县', null, '1');
INSERT INTO `t_pca` VALUES ('131127', '景县', null, '1');
INSERT INTO `t_pca` VALUES ('131128', '阜城县', null, '1');
INSERT INTO `t_pca` VALUES ('131182', '深州市', null, '1');
INSERT INTO `t_pca` VALUES ('140000', '山西省', null, '1');
INSERT INTO `t_pca` VALUES ('140100', '太原市', null, '1');
INSERT INTO `t_pca` VALUES ('140105', '小店区', null, '1');
INSERT INTO `t_pca` VALUES ('140106', '迎泽区', null, '1');
INSERT INTO `t_pca` VALUES ('140107', '杏花岭区', null, '1');
INSERT INTO `t_pca` VALUES ('140108', '尖草坪区', null, '1');
INSERT INTO `t_pca` VALUES ('140109', '万柏林区', null, '1');
INSERT INTO `t_pca` VALUES ('140110', '晋源区', null, '1');
INSERT INTO `t_pca` VALUES ('140121', '清徐县', null, '1');
INSERT INTO `t_pca` VALUES ('140122', '阳曲县', null, '1');
INSERT INTO `t_pca` VALUES ('140123', '娄烦县', null, '1');
INSERT INTO `t_pca` VALUES ('140181', '古交市', null, '1');
INSERT INTO `t_pca` VALUES ('140200', '大同市', null, '1');
INSERT INTO `t_pca` VALUES ('140202', '城区', null, '1');
INSERT INTO `t_pca` VALUES ('140203', '矿区', null, '1');
INSERT INTO `t_pca` VALUES ('140211', '南郊区', null, '1');
INSERT INTO `t_pca` VALUES ('140212', '新荣区', null, '1');
INSERT INTO `t_pca` VALUES ('140221', '阳高县', null, '1');
INSERT INTO `t_pca` VALUES ('140222', '天镇县', null, '1');
INSERT INTO `t_pca` VALUES ('140223', '广灵县', null, '1');
INSERT INTO `t_pca` VALUES ('140224', '灵丘县', null, '1');
INSERT INTO `t_pca` VALUES ('140225', '浑源县', null, '1');
INSERT INTO `t_pca` VALUES ('140226', '左云县', null, '1');
INSERT INTO `t_pca` VALUES ('140227', '大同县', null, '1');
INSERT INTO `t_pca` VALUES ('140300', '阳泉市', null, '1');
INSERT INTO `t_pca` VALUES ('140302', '城区', null, '1');
INSERT INTO `t_pca` VALUES ('140303', '矿区', null, '1');
INSERT INTO `t_pca` VALUES ('140311', '郊区', null, '1');
INSERT INTO `t_pca` VALUES ('140321', '平定县', null, '1');
INSERT INTO `t_pca` VALUES ('140322', '盂县', null, '1');
INSERT INTO `t_pca` VALUES ('140400', '长治市', null, '1');
INSERT INTO `t_pca` VALUES ('140402', '城区', null, '1');
INSERT INTO `t_pca` VALUES ('140411', '郊区', null, '1');
INSERT INTO `t_pca` VALUES ('140421', '长治县', null, '1');
INSERT INTO `t_pca` VALUES ('140423', '襄垣县', null, '1');
INSERT INTO `t_pca` VALUES ('140424', '屯留县', null, '1');
INSERT INTO `t_pca` VALUES ('140425', '平顺县', null, '1');
INSERT INTO `t_pca` VALUES ('140426', '黎城县', null, '1');
INSERT INTO `t_pca` VALUES ('140427', '壶关县', null, '1');
INSERT INTO `t_pca` VALUES ('140428', '长子县', null, '1');
INSERT INTO `t_pca` VALUES ('140429', '武乡县', null, '1');
INSERT INTO `t_pca` VALUES ('140430', '沁县', null, '1');
INSERT INTO `t_pca` VALUES ('140431', '沁源县', null, '1');
INSERT INTO `t_pca` VALUES ('140481', '潞城市', null, '1');
INSERT INTO `t_pca` VALUES ('140500', '晋城市', null, '1');
INSERT INTO `t_pca` VALUES ('140502', '城区', null, '1');
INSERT INTO `t_pca` VALUES ('140521', '沁水县', null, '1');
INSERT INTO `t_pca` VALUES ('140522', '阳城县', null, '1');
INSERT INTO `t_pca` VALUES ('140524', '陵川县', null, '1');
INSERT INTO `t_pca` VALUES ('140525', '泽州县', null, '1');
INSERT INTO `t_pca` VALUES ('140581', '高平市', null, '1');
INSERT INTO `t_pca` VALUES ('140600', '朔州市', null, '1');
INSERT INTO `t_pca` VALUES ('140602', '朔城区', null, '1');
INSERT INTO `t_pca` VALUES ('140603', '平鲁区', null, '1');
INSERT INTO `t_pca` VALUES ('140621', '山阴县', null, '1');
INSERT INTO `t_pca` VALUES ('140622', '应县', null, '1');
INSERT INTO `t_pca` VALUES ('140623', '右玉县', null, '1');
INSERT INTO `t_pca` VALUES ('140624', '怀仁县', null, '1');
INSERT INTO `t_pca` VALUES ('140700', '晋中市', null, '1');
INSERT INTO `t_pca` VALUES ('140702', '榆次区', null, '1');
INSERT INTO `t_pca` VALUES ('140721', '榆社县', null, '1');
INSERT INTO `t_pca` VALUES ('140722', '左权县', null, '1');
INSERT INTO `t_pca` VALUES ('140723', '和顺县', null, '1');
INSERT INTO `t_pca` VALUES ('140724', '昔阳县', null, '1');
INSERT INTO `t_pca` VALUES ('140725', '寿阳县', null, '1');
INSERT INTO `t_pca` VALUES ('140726', '太谷县', null, '1');
INSERT INTO `t_pca` VALUES ('140727', '祁县', null, '1');
INSERT INTO `t_pca` VALUES ('140728', '平遥县', null, '1');
INSERT INTO `t_pca` VALUES ('140729', '灵石县', null, '1');
INSERT INTO `t_pca` VALUES ('140781', '介休市', null, '1');
INSERT INTO `t_pca` VALUES ('140800', '运城市', null, '1');
INSERT INTO `t_pca` VALUES ('140802', '盐湖区', null, '1');
INSERT INTO `t_pca` VALUES ('140821', '临猗县', null, '1');
INSERT INTO `t_pca` VALUES ('140822', '万荣县', null, '1');
INSERT INTO `t_pca` VALUES ('140823', '闻喜县', null, '1');
INSERT INTO `t_pca` VALUES ('140824', '稷山县', null, '1');
INSERT INTO `t_pca` VALUES ('140825', '新绛县', null, '1');
INSERT INTO `t_pca` VALUES ('140826', '绛县', null, '1');
INSERT INTO `t_pca` VALUES ('140827', '垣曲县', null, '1');
INSERT INTO `t_pca` VALUES ('140828', '夏县', null, '1');
INSERT INTO `t_pca` VALUES ('140829', '平陆县', null, '1');
INSERT INTO `t_pca` VALUES ('140830', '芮城县', null, '1');
INSERT INTO `t_pca` VALUES ('140881', '永济市', null, '1');
INSERT INTO `t_pca` VALUES ('140882', '河津市', null, '1');
INSERT INTO `t_pca` VALUES ('140900', '忻州市', null, '1');
INSERT INTO `t_pca` VALUES ('140902', '忻府区', null, '1');
INSERT INTO `t_pca` VALUES ('140921', '定襄县', null, '1');
INSERT INTO `t_pca` VALUES ('140922', '五台县', null, '1');
INSERT INTO `t_pca` VALUES ('140923', '代县', null, '1');
INSERT INTO `t_pca` VALUES ('140924', '繁峙县', null, '1');
INSERT INTO `t_pca` VALUES ('140925', '宁武县', null, '1');
INSERT INTO `t_pca` VALUES ('140926', '静乐县', null, '1');
INSERT INTO `t_pca` VALUES ('140927', '神池县', null, '1');
INSERT INTO `t_pca` VALUES ('140928', '五寨县', null, '1');
INSERT INTO `t_pca` VALUES ('140929', '岢岚县', null, '1');
INSERT INTO `t_pca` VALUES ('140930', '河曲县', null, '1');
INSERT INTO `t_pca` VALUES ('140931', '保德县', null, '1');
INSERT INTO `t_pca` VALUES ('140932', '偏关县', null, '1');
INSERT INTO `t_pca` VALUES ('140981', '原平市', null, '1');
INSERT INTO `t_pca` VALUES ('141000', '临汾市', null, '1');
INSERT INTO `t_pca` VALUES ('141002', '尧都区', null, '1');
INSERT INTO `t_pca` VALUES ('141021', '曲沃县', null, '1');
INSERT INTO `t_pca` VALUES ('141022', '翼城县', null, '1');
INSERT INTO `t_pca` VALUES ('141023', '襄汾县', null, '1');
INSERT INTO `t_pca` VALUES ('141024', '洪洞县', null, '1');
INSERT INTO `t_pca` VALUES ('141025', '古县', null, '1');
INSERT INTO `t_pca` VALUES ('141026', '安泽县', null, '1');
INSERT INTO `t_pca` VALUES ('141027', '浮山县', null, '1');
INSERT INTO `t_pca` VALUES ('141028', '吉县', null, '1');
INSERT INTO `t_pca` VALUES ('141029', '乡宁县', null, '1');
INSERT INTO `t_pca` VALUES ('141030', '大宁县', null, '1');
INSERT INTO `t_pca` VALUES ('141031', '隰县', null, '1');
INSERT INTO `t_pca` VALUES ('141032', '永和县', null, '1');
INSERT INTO `t_pca` VALUES ('141033', '蒲县', null, '1');
INSERT INTO `t_pca` VALUES ('141034', '汾西县', null, '1');
INSERT INTO `t_pca` VALUES ('141081', '侯马市', null, '1');
INSERT INTO `t_pca` VALUES ('141082', '霍州市', null, '1');
INSERT INTO `t_pca` VALUES ('141100', '吕梁市', null, '1');
INSERT INTO `t_pca` VALUES ('141102', '离石区', null, '1');
INSERT INTO `t_pca` VALUES ('141121', '文水县', null, '1');
INSERT INTO `t_pca` VALUES ('141122', '交城县', null, '1');
INSERT INTO `t_pca` VALUES ('141123', '兴县', null, '1');
INSERT INTO `t_pca` VALUES ('141124', '临县', null, '1');
INSERT INTO `t_pca` VALUES ('141125', '柳林县', null, '1');
INSERT INTO `t_pca` VALUES ('141126', '石楼县', null, '1');
INSERT INTO `t_pca` VALUES ('141127', '岚县', null, '1');
INSERT INTO `t_pca` VALUES ('141128', '方山县', null, '1');
INSERT INTO `t_pca` VALUES ('141129', '中阳县', null, '1');
INSERT INTO `t_pca` VALUES ('141130', '交口县', null, '1');
INSERT INTO `t_pca` VALUES ('141181', '孝义市', null, '1');
INSERT INTO `t_pca` VALUES ('141182', '汾阳市', null, '1');
INSERT INTO `t_pca` VALUES ('150000', '内蒙古自治区', null, '1');
INSERT INTO `t_pca` VALUES ('150100', '呼和浩特市', null, '1');
INSERT INTO `t_pca` VALUES ('150102', '新城区', null, '1');
INSERT INTO `t_pca` VALUES ('150103', '回民区', null, '1');
INSERT INTO `t_pca` VALUES ('150104', '玉泉区', null, '1');
INSERT INTO `t_pca` VALUES ('150105', '赛罕区', null, '1');
INSERT INTO `t_pca` VALUES ('150121', '土默特左旗', null, '1');
INSERT INTO `t_pca` VALUES ('150122', '托克托县', null, '1');
INSERT INTO `t_pca` VALUES ('150123', '和林格尔县', null, '1');
INSERT INTO `t_pca` VALUES ('150124', '清水河县', null, '1');
INSERT INTO `t_pca` VALUES ('150125', '武川县', null, '1');
INSERT INTO `t_pca` VALUES ('150200', '包头市', null, '1');
INSERT INTO `t_pca` VALUES ('150202', '东河区', null, '1');
INSERT INTO `t_pca` VALUES ('150203', '昆都仑区', null, '1');
INSERT INTO `t_pca` VALUES ('150204', '青山区', null, '1');
INSERT INTO `t_pca` VALUES ('150205', '石拐区', null, '1');
INSERT INTO `t_pca` VALUES ('150206', '白云鄂博矿区', null, '1');
INSERT INTO `t_pca` VALUES ('150207', '九原区', null, '1');
INSERT INTO `t_pca` VALUES ('150221', '土默特右旗', null, '1');
INSERT INTO `t_pca` VALUES ('150222', '固阳县', null, '1');
INSERT INTO `t_pca` VALUES ('150223', '达尔罕茂明安联合旗', null, '1');
INSERT INTO `t_pca` VALUES ('150300', '乌海市', null, '1');
INSERT INTO `t_pca` VALUES ('150302', '海勃湾区', null, '1');
INSERT INTO `t_pca` VALUES ('150303', '海南区', null, '1');
INSERT INTO `t_pca` VALUES ('150304', '乌达区', null, '1');
INSERT INTO `t_pca` VALUES ('150400', '赤峰市', null, '1');
INSERT INTO `t_pca` VALUES ('150402', '红山区', null, '1');
INSERT INTO `t_pca` VALUES ('150403', '元宝山区', null, '1');
INSERT INTO `t_pca` VALUES ('150404', '松山区', null, '1');
INSERT INTO `t_pca` VALUES ('150421', '阿鲁科尔沁旗', null, '1');
INSERT INTO `t_pca` VALUES ('150422', '巴林左旗', null, '1');
INSERT INTO `t_pca` VALUES ('150423', '巴林右旗', null, '1');
INSERT INTO `t_pca` VALUES ('150424', '林西县', null, '1');
INSERT INTO `t_pca` VALUES ('150425', '克什克腾旗', null, '1');
INSERT INTO `t_pca` VALUES ('150426', '翁牛特旗', null, '1');
INSERT INTO `t_pca` VALUES ('150428', '喀喇沁旗', null, '1');
INSERT INTO `t_pca` VALUES ('150429', '宁城县', null, '1');
INSERT INTO `t_pca` VALUES ('150430', '敖汉旗', null, '1');
INSERT INTO `t_pca` VALUES ('150500', '通辽市', null, '1');
INSERT INTO `t_pca` VALUES ('150502', '科尔沁区', null, '1');
INSERT INTO `t_pca` VALUES ('150521', '科尔沁左翼中旗', null, '1');
INSERT INTO `t_pca` VALUES ('150522', '科尔沁左翼后旗', null, '1');
INSERT INTO `t_pca` VALUES ('150523', '开鲁县', null, '1');
INSERT INTO `t_pca` VALUES ('150524', '库伦旗', null, '1');
INSERT INTO `t_pca` VALUES ('150525', '奈曼旗', null, '1');
INSERT INTO `t_pca` VALUES ('150526', '扎鲁特旗', null, '1');
INSERT INTO `t_pca` VALUES ('150581', '霍林郭勒市', null, '1');
INSERT INTO `t_pca` VALUES ('150600', '鄂尔多斯市', null, '1');
INSERT INTO `t_pca` VALUES ('150602', '东胜区', null, '1');
INSERT INTO `t_pca` VALUES ('150603', '康巴什区', null, '1');
INSERT INTO `t_pca` VALUES ('150621', '达拉特旗', null, '1');
INSERT INTO `t_pca` VALUES ('150622', '准格尔旗', null, '1');
INSERT INTO `t_pca` VALUES ('150623', '鄂托克前旗', null, '1');
INSERT INTO `t_pca` VALUES ('150624', '鄂托克旗', null, '1');
INSERT INTO `t_pca` VALUES ('150625', '杭锦旗', null, '1');
INSERT INTO `t_pca` VALUES ('150626', '乌审旗', null, '1');
INSERT INTO `t_pca` VALUES ('150627', '伊金霍洛旗', null, '1');
INSERT INTO `t_pca` VALUES ('150700', '呼伦贝尔市', null, '1');
INSERT INTO `t_pca` VALUES ('150702', '海拉尔区', null, '1');
INSERT INTO `t_pca` VALUES ('150703', '扎赉诺尔区', null, '1');
INSERT INTO `t_pca` VALUES ('150721', '阿荣旗', null, '1');
INSERT INTO `t_pca` VALUES ('150722', '莫力达瓦达斡尔族自治旗', null, '1');
INSERT INTO `t_pca` VALUES ('150723', '鄂伦春自治旗', null, '1');
INSERT INTO `t_pca` VALUES ('150724', '鄂温克族自治旗', null, '1');
INSERT INTO `t_pca` VALUES ('150725', '陈巴尔虎旗', null, '1');
INSERT INTO `t_pca` VALUES ('150726', '新巴尔虎左旗', null, '1');
INSERT INTO `t_pca` VALUES ('150727', '新巴尔虎右旗', null, '1');
INSERT INTO `t_pca` VALUES ('150781', '满洲里市', null, '1');
INSERT INTO `t_pca` VALUES ('150782', '牙克石市', null, '1');
INSERT INTO `t_pca` VALUES ('150783', '扎兰屯市', null, '1');
INSERT INTO `t_pca` VALUES ('150784', '额尔古纳市', null, '1');
INSERT INTO `t_pca` VALUES ('150785', '根河市', null, '1');
INSERT INTO `t_pca` VALUES ('150800', '巴彦淖尔市', null, '1');
INSERT INTO `t_pca` VALUES ('150802', '临河区', null, '1');
INSERT INTO `t_pca` VALUES ('150821', '五原县', null, '1');
INSERT INTO `t_pca` VALUES ('150822', '磴口县', null, '1');
INSERT INTO `t_pca` VALUES ('150823', '乌拉特前旗', null, '1');
INSERT INTO `t_pca` VALUES ('150824', '乌拉特中旗', null, '1');
INSERT INTO `t_pca` VALUES ('150825', '乌拉特后旗', null, '1');
INSERT INTO `t_pca` VALUES ('150826', '杭锦后旗', null, '1');
INSERT INTO `t_pca` VALUES ('150900', '乌兰察布市', null, '1');
INSERT INTO `t_pca` VALUES ('150902', '集宁区', null, '1');
INSERT INTO `t_pca` VALUES ('150921', '卓资县', null, '1');
INSERT INTO `t_pca` VALUES ('150922', '化德县', null, '1');
INSERT INTO `t_pca` VALUES ('150923', '商都县', null, '1');
INSERT INTO `t_pca` VALUES ('150924', '兴和县', null, '1');
INSERT INTO `t_pca` VALUES ('150925', '凉城县', null, '1');
INSERT INTO `t_pca` VALUES ('150926', '察哈尔右翼前旗', null, '1');
INSERT INTO `t_pca` VALUES ('150927', '察哈尔右翼中旗', null, '1');
INSERT INTO `t_pca` VALUES ('150928', '察哈尔右翼后旗', null, '1');
INSERT INTO `t_pca` VALUES ('150929', '四子王旗', null, '1');
INSERT INTO `t_pca` VALUES ('150981', '丰镇市', null, '1');
INSERT INTO `t_pca` VALUES ('152200', '兴安盟', null, '1');
INSERT INTO `t_pca` VALUES ('152201', '乌兰浩特市', null, '1');
INSERT INTO `t_pca` VALUES ('152202', '阿尔山市', null, '1');
INSERT INTO `t_pca` VALUES ('152221', '科尔沁右翼前旗', null, '1');
INSERT INTO `t_pca` VALUES ('152222', '科尔沁右翼中旗', null, '1');
INSERT INTO `t_pca` VALUES ('152223', '扎赉特旗', null, '1');
INSERT INTO `t_pca` VALUES ('152224', '突泉县', null, '1');
INSERT INTO `t_pca` VALUES ('152500', '锡林郭勒盟', null, '1');
INSERT INTO `t_pca` VALUES ('152501', '二连浩特市', null, '1');
INSERT INTO `t_pca` VALUES ('152502', '锡林浩特市', null, '1');
INSERT INTO `t_pca` VALUES ('152522', '阿巴嘎旗', null, '1');
INSERT INTO `t_pca` VALUES ('152523', '苏尼特左旗', null, '1');
INSERT INTO `t_pca` VALUES ('152524', '苏尼特右旗', null, '1');
INSERT INTO `t_pca` VALUES ('152525', '东乌珠穆沁旗', null, '1');
INSERT INTO `t_pca` VALUES ('152526', '西乌珠穆沁旗', null, '1');
INSERT INTO `t_pca` VALUES ('152527', '太仆寺旗', null, '1');
INSERT INTO `t_pca` VALUES ('152528', '镶黄旗', null, '1');
INSERT INTO `t_pca` VALUES ('152529', '正镶白旗', null, '1');
INSERT INTO `t_pca` VALUES ('152530', '正蓝旗', null, '1');
INSERT INTO `t_pca` VALUES ('152531', '多伦县', null, '1');
INSERT INTO `t_pca` VALUES ('152900', '阿拉善盟', null, '1');
INSERT INTO `t_pca` VALUES ('152921', '阿拉善左旗', null, '1');
INSERT INTO `t_pca` VALUES ('152922', '阿拉善右旗', null, '1');
INSERT INTO `t_pca` VALUES ('152923', '额济纳旗', null, '1');
INSERT INTO `t_pca` VALUES ('210000', '辽宁省', null, '1');
INSERT INTO `t_pca` VALUES ('210100', '沈阳市', null, '1');
INSERT INTO `t_pca` VALUES ('210102', '和平区', null, '1');
INSERT INTO `t_pca` VALUES ('210103', '沈河区', null, '1');
INSERT INTO `t_pca` VALUES ('210104', '大东区', null, '1');
INSERT INTO `t_pca` VALUES ('210105', '皇姑区', null, '1');
INSERT INTO `t_pca` VALUES ('210106', '铁西区', null, '1');
INSERT INTO `t_pca` VALUES ('210111', '苏家屯区', null, '1');
INSERT INTO `t_pca` VALUES ('210112', '浑南区', null, '1');
INSERT INTO `t_pca` VALUES ('210113', '沈北新区', null, '1');
INSERT INTO `t_pca` VALUES ('210114', '于洪区', null, '1');
INSERT INTO `t_pca` VALUES ('210115', '辽中区', null, '1');
INSERT INTO `t_pca` VALUES ('210123', '康平县', null, '1');
INSERT INTO `t_pca` VALUES ('210124', '法库县', null, '1');
INSERT INTO `t_pca` VALUES ('210181', '新民市', null, '1');
INSERT INTO `t_pca` VALUES ('210200', '大连市', null, '1');
INSERT INTO `t_pca` VALUES ('210202', '中山区', null, '1');
INSERT INTO `t_pca` VALUES ('210203', '西岗区', null, '1');
INSERT INTO `t_pca` VALUES ('210204', '沙河口区', null, '1');
INSERT INTO `t_pca` VALUES ('210211', '甘井子区', null, '1');
INSERT INTO `t_pca` VALUES ('210212', '旅顺口区', null, '1');
INSERT INTO `t_pca` VALUES ('210213', '金州区', null, '1');
INSERT INTO `t_pca` VALUES ('210214', '普兰店区', null, '1');
INSERT INTO `t_pca` VALUES ('210224', '长海县', null, '1');
INSERT INTO `t_pca` VALUES ('210281', '瓦房店市', null, '1');
INSERT INTO `t_pca` VALUES ('210283', '庄河市', null, '1');
INSERT INTO `t_pca` VALUES ('210300', '鞍山市', null, '1');
INSERT INTO `t_pca` VALUES ('210302', '铁东区', null, '1');
INSERT INTO `t_pca` VALUES ('210303', '铁西区', null, '1');
INSERT INTO `t_pca` VALUES ('210304', '立山区', null, '1');
INSERT INTO `t_pca` VALUES ('210311', '千山区', null, '1');
INSERT INTO `t_pca` VALUES ('210321', '台安县', null, '1');
INSERT INTO `t_pca` VALUES ('210323', '岫岩满族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('210381', '海城市', null, '1');
INSERT INTO `t_pca` VALUES ('210400', '抚顺市', null, '1');
INSERT INTO `t_pca` VALUES ('210402', '新抚区', null, '1');
INSERT INTO `t_pca` VALUES ('210403', '东洲区', null, '1');
INSERT INTO `t_pca` VALUES ('210404', '望花区', null, '1');
INSERT INTO `t_pca` VALUES ('210411', '顺城区', null, '1');
INSERT INTO `t_pca` VALUES ('210421', '抚顺县', null, '1');
INSERT INTO `t_pca` VALUES ('210422', '新宾满族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('210423', '清原满族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('210500', '本溪市', null, '1');
INSERT INTO `t_pca` VALUES ('210502', '平山区', null, '1');
INSERT INTO `t_pca` VALUES ('210503', '溪湖区', null, '1');
INSERT INTO `t_pca` VALUES ('210504', '明山区', null, '1');
INSERT INTO `t_pca` VALUES ('210505', '南芬区', null, '1');
INSERT INTO `t_pca` VALUES ('210521', '本溪满族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('210522', '桓仁满族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('210600', '丹东市', null, '1');
INSERT INTO `t_pca` VALUES ('210602', '元宝区', null, '1');
INSERT INTO `t_pca` VALUES ('210603', '振兴区', null, '1');
INSERT INTO `t_pca` VALUES ('210604', '振安区', null, '1');
INSERT INTO `t_pca` VALUES ('210624', '宽甸满族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('210681', '东港市', null, '1');
INSERT INTO `t_pca` VALUES ('210682', '凤城市', null, '1');
INSERT INTO `t_pca` VALUES ('210700', '锦州市', null, '1');
INSERT INTO `t_pca` VALUES ('210702', '古塔区', null, '1');
INSERT INTO `t_pca` VALUES ('210703', '凌河区', null, '1');
INSERT INTO `t_pca` VALUES ('210711', '太和区', null, '1');
INSERT INTO `t_pca` VALUES ('210726', '黑山县', null, '1');
INSERT INTO `t_pca` VALUES ('210727', '义县', null, '1');
INSERT INTO `t_pca` VALUES ('210781', '凌海市', null, '1');
INSERT INTO `t_pca` VALUES ('210782', '北镇市', null, '1');
INSERT INTO `t_pca` VALUES ('210800', '营口市', null, '1');
INSERT INTO `t_pca` VALUES ('210802', '站前区', null, '1');
INSERT INTO `t_pca` VALUES ('210803', '西市区', null, '1');
INSERT INTO `t_pca` VALUES ('210804', '鲅鱼圈区', null, '1');
INSERT INTO `t_pca` VALUES ('210811', '老边区', null, '1');
INSERT INTO `t_pca` VALUES ('210881', '盖州市', null, '1');
INSERT INTO `t_pca` VALUES ('210882', '大石桥市', null, '1');
INSERT INTO `t_pca` VALUES ('210900', '阜新市', null, '1');
INSERT INTO `t_pca` VALUES ('210902', '海州区', null, '1');
INSERT INTO `t_pca` VALUES ('210903', '新邱区', null, '1');
INSERT INTO `t_pca` VALUES ('210904', '太平区', null, '1');
INSERT INTO `t_pca` VALUES ('210905', '清河门区', null, '1');
INSERT INTO `t_pca` VALUES ('210911', '细河区', null, '1');
INSERT INTO `t_pca` VALUES ('210921', '阜新蒙古族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('210922', '彰武县', null, '1');
INSERT INTO `t_pca` VALUES ('211000', '辽阳市', null, '1');
INSERT INTO `t_pca` VALUES ('211002', '白塔区', null, '1');
INSERT INTO `t_pca` VALUES ('211003', '文圣区', null, '1');
INSERT INTO `t_pca` VALUES ('211004', '宏伟区', null, '1');
INSERT INTO `t_pca` VALUES ('211005', '弓长岭区', null, '1');
INSERT INTO `t_pca` VALUES ('211011', '太子河区', null, '1');
INSERT INTO `t_pca` VALUES ('211021', '辽阳县', null, '1');
INSERT INTO `t_pca` VALUES ('211081', '灯塔市', null, '1');
INSERT INTO `t_pca` VALUES ('211100', '盘锦市', null, '1');
INSERT INTO `t_pca` VALUES ('211102', '双台子区', null, '1');
INSERT INTO `t_pca` VALUES ('211103', '兴隆台区', null, '1');
INSERT INTO `t_pca` VALUES ('211104', '大洼区', null, '1');
INSERT INTO `t_pca` VALUES ('211122', '盘山县', null, '1');
INSERT INTO `t_pca` VALUES ('211200', '铁岭市', null, '1');
INSERT INTO `t_pca` VALUES ('211202', '银州区', null, '1');
INSERT INTO `t_pca` VALUES ('211204', '清河区', null, '1');
INSERT INTO `t_pca` VALUES ('211221', '铁岭县', null, '1');
INSERT INTO `t_pca` VALUES ('211223', '西丰县', null, '1');
INSERT INTO `t_pca` VALUES ('211224', '昌图县', null, '1');
INSERT INTO `t_pca` VALUES ('211281', '调兵山市', null, '1');
INSERT INTO `t_pca` VALUES ('211282', '开原市', null, '1');
INSERT INTO `t_pca` VALUES ('211300', '朝阳市', null, '1');
INSERT INTO `t_pca` VALUES ('211302', '双塔区', null, '1');
INSERT INTO `t_pca` VALUES ('211303', '龙城区', null, '1');
INSERT INTO `t_pca` VALUES ('211321', '朝阳县', null, '1');
INSERT INTO `t_pca` VALUES ('211322', '建平县', null, '1');
INSERT INTO `t_pca` VALUES ('211324', '喀喇沁左翼蒙古族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('211381', '北票市', null, '1');
INSERT INTO `t_pca` VALUES ('211382', '凌源市', null, '1');
INSERT INTO `t_pca` VALUES ('211400', '葫芦岛市', null, '1');
INSERT INTO `t_pca` VALUES ('211402', '连山区', null, '1');
INSERT INTO `t_pca` VALUES ('211403', '龙港区', null, '1');
INSERT INTO `t_pca` VALUES ('211404', '南票区', null, '1');
INSERT INTO `t_pca` VALUES ('211421', '绥中县', null, '1');
INSERT INTO `t_pca` VALUES ('211422', '建昌县', null, '1');
INSERT INTO `t_pca` VALUES ('211481', '兴城市', null, '1');
INSERT INTO `t_pca` VALUES ('220000', '吉林省', null, '1');
INSERT INTO `t_pca` VALUES ('220100', '长春市', null, '1');
INSERT INTO `t_pca` VALUES ('220102', '南关区', null, '1');
INSERT INTO `t_pca` VALUES ('220103', '宽城区', null, '1');
INSERT INTO `t_pca` VALUES ('220104', '朝阳区', null, '1');
INSERT INTO `t_pca` VALUES ('220105', '二道区', null, '1');
INSERT INTO `t_pca` VALUES ('220106', '绿园区', null, '1');
INSERT INTO `t_pca` VALUES ('220112', '双阳区', null, '1');
INSERT INTO `t_pca` VALUES ('220113', '九台区', null, '1');
INSERT INTO `t_pca` VALUES ('220122', '农安县', null, '1');
INSERT INTO `t_pca` VALUES ('220182', '榆树市', null, '1');
INSERT INTO `t_pca` VALUES ('220183', '德惠市', null, '1');
INSERT INTO `t_pca` VALUES ('220200', '吉林市', null, '1');
INSERT INTO `t_pca` VALUES ('220202', '昌邑区', null, '1');
INSERT INTO `t_pca` VALUES ('220203', '龙潭区', null, '1');
INSERT INTO `t_pca` VALUES ('220204', '船营区', null, '1');
INSERT INTO `t_pca` VALUES ('220211', '丰满区', null, '1');
INSERT INTO `t_pca` VALUES ('220221', '永吉县', null, '1');
INSERT INTO `t_pca` VALUES ('220281', '蛟河市', null, '1');
INSERT INTO `t_pca` VALUES ('220282', '桦甸市', null, '1');
INSERT INTO `t_pca` VALUES ('220283', '舒兰市', null, '1');
INSERT INTO `t_pca` VALUES ('220284', '磐石市', null, '1');
INSERT INTO `t_pca` VALUES ('220300', '四平市', null, '1');
INSERT INTO `t_pca` VALUES ('220302', '铁西区', null, '1');
INSERT INTO `t_pca` VALUES ('220303', '铁东区', null, '1');
INSERT INTO `t_pca` VALUES ('220322', '梨树县', null, '1');
INSERT INTO `t_pca` VALUES ('220323', '伊通满族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('220381', '公主岭市', null, '1');
INSERT INTO `t_pca` VALUES ('220382', '双辽市', null, '1');
INSERT INTO `t_pca` VALUES ('220400', '辽源市', null, '1');
INSERT INTO `t_pca` VALUES ('220402', '龙山区', null, '1');
INSERT INTO `t_pca` VALUES ('220403', '西安区', null, '1');
INSERT INTO `t_pca` VALUES ('220421', '东丰县', null, '1');
INSERT INTO `t_pca` VALUES ('220422', '东辽县', null, '1');
INSERT INTO `t_pca` VALUES ('220500', '通化市', null, '1');
INSERT INTO `t_pca` VALUES ('220502', '东昌区', null, '1');
INSERT INTO `t_pca` VALUES ('220503', '二道江区', null, '1');
INSERT INTO `t_pca` VALUES ('220521', '通化县', null, '1');
INSERT INTO `t_pca` VALUES ('220523', '辉南县', null, '1');
INSERT INTO `t_pca` VALUES ('220524', '柳河县', null, '1');
INSERT INTO `t_pca` VALUES ('220581', '梅河口市', null, '1');
INSERT INTO `t_pca` VALUES ('220582', '集安市', null, '1');
INSERT INTO `t_pca` VALUES ('220600', '白山市', null, '1');
INSERT INTO `t_pca` VALUES ('220602', '浑江区', null, '1');
INSERT INTO `t_pca` VALUES ('220605', '江源区', null, '1');
INSERT INTO `t_pca` VALUES ('220621', '抚松县', null, '1');
INSERT INTO `t_pca` VALUES ('220622', '靖宇县', null, '1');
INSERT INTO `t_pca` VALUES ('220623', '长白朝鲜族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('220681', '临江市', null, '1');
INSERT INTO `t_pca` VALUES ('220700', '松原市', null, '1');
INSERT INTO `t_pca` VALUES ('220702', '宁江区', null, '1');
INSERT INTO `t_pca` VALUES ('220721', '前郭尔罗斯蒙古族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('220722', '长岭县', null, '1');
INSERT INTO `t_pca` VALUES ('220723', '乾安县', null, '1');
INSERT INTO `t_pca` VALUES ('220781', '扶余市', null, '1');
INSERT INTO `t_pca` VALUES ('220800', '白城市', null, '1');
INSERT INTO `t_pca` VALUES ('220802', '洮北区', null, '1');
INSERT INTO `t_pca` VALUES ('220821', '镇赉县', null, '1');
INSERT INTO `t_pca` VALUES ('220822', '通榆县', null, '1');
INSERT INTO `t_pca` VALUES ('220881', '洮南市', null, '1');
INSERT INTO `t_pca` VALUES ('220882', '大安市', null, '1');
INSERT INTO `t_pca` VALUES ('222400', '延边朝鲜族自治州', null, '1');
INSERT INTO `t_pca` VALUES ('222401', '延吉市', null, '1');
INSERT INTO `t_pca` VALUES ('222402', '图们市', null, '1');
INSERT INTO `t_pca` VALUES ('222403', '敦化市', null, '1');
INSERT INTO `t_pca` VALUES ('222404', '珲春市', null, '1');
INSERT INTO `t_pca` VALUES ('222405', '龙井市', null, '1');
INSERT INTO `t_pca` VALUES ('222406', '和龙市', null, '1');
INSERT INTO `t_pca` VALUES ('222424', '汪清县', null, '1');
INSERT INTO `t_pca` VALUES ('222426', '安图县', null, '1');
INSERT INTO `t_pca` VALUES ('230000', '黑龙江省', null, '1');
INSERT INTO `t_pca` VALUES ('230100', '哈尔滨市', null, '1');
INSERT INTO `t_pca` VALUES ('230102', '道里区', null, '1');
INSERT INTO `t_pca` VALUES ('230103', '南岗区', null, '1');
INSERT INTO `t_pca` VALUES ('230104', '道外区', null, '1');
INSERT INTO `t_pca` VALUES ('230108', '平房区', null, '1');
INSERT INTO `t_pca` VALUES ('230109', '松北区', null, '1');
INSERT INTO `t_pca` VALUES ('230110', '香坊区', null, '1');
INSERT INTO `t_pca` VALUES ('230111', '呼兰区', null, '1');
INSERT INTO `t_pca` VALUES ('230112', '阿城区', null, '1');
INSERT INTO `t_pca` VALUES ('230113', '双城区', null, '1');
INSERT INTO `t_pca` VALUES ('230123', '依兰县', null, '1');
INSERT INTO `t_pca` VALUES ('230124', '方正县', null, '1');
INSERT INTO `t_pca` VALUES ('230125', '宾县', null, '1');
INSERT INTO `t_pca` VALUES ('230126', '巴彦县', null, '1');
INSERT INTO `t_pca` VALUES ('230127', '木兰县', null, '1');
INSERT INTO `t_pca` VALUES ('230128', '通河县', null, '1');
INSERT INTO `t_pca` VALUES ('230129', '延寿县', null, '1');
INSERT INTO `t_pca` VALUES ('230183', '尚志市', null, '1');
INSERT INTO `t_pca` VALUES ('230184', '五常市', null, '1');
INSERT INTO `t_pca` VALUES ('230200', '齐齐哈尔市', null, '1');
INSERT INTO `t_pca` VALUES ('230202', '龙沙区', null, '1');
INSERT INTO `t_pca` VALUES ('230203', '建华区', null, '1');
INSERT INTO `t_pca` VALUES ('230204', '铁锋区', null, '1');
INSERT INTO `t_pca` VALUES ('230205', '昂昂溪区', null, '1');
INSERT INTO `t_pca` VALUES ('230206', '富拉尔基区', null, '1');
INSERT INTO `t_pca` VALUES ('230207', '碾子山区', null, '1');
INSERT INTO `t_pca` VALUES ('230208', '梅里斯达斡尔族区', null, '1');
INSERT INTO `t_pca` VALUES ('230221', '龙江县', null, '1');
INSERT INTO `t_pca` VALUES ('230223', '依安县', null, '1');
INSERT INTO `t_pca` VALUES ('230224', '泰来县', null, '1');
INSERT INTO `t_pca` VALUES ('230225', '甘南县', null, '1');
INSERT INTO `t_pca` VALUES ('230227', '富裕县', null, '1');
INSERT INTO `t_pca` VALUES ('230229', '克山县', null, '1');
INSERT INTO `t_pca` VALUES ('230230', '克东县', null, '1');
INSERT INTO `t_pca` VALUES ('230231', '拜泉县', null, '1');
INSERT INTO `t_pca` VALUES ('230281', '讷河市', null, '1');
INSERT INTO `t_pca` VALUES ('230300', '鸡西市', null, '1');
INSERT INTO `t_pca` VALUES ('230302', '鸡冠区', null, '1');
INSERT INTO `t_pca` VALUES ('230303', '恒山区', null, '1');
INSERT INTO `t_pca` VALUES ('230304', '滴道区', null, '1');
INSERT INTO `t_pca` VALUES ('230305', '梨树区', null, '1');
INSERT INTO `t_pca` VALUES ('230306', '城子河区', null, '1');
INSERT INTO `t_pca` VALUES ('230307', '麻山区', null, '1');
INSERT INTO `t_pca` VALUES ('230321', '鸡东县', null, '1');
INSERT INTO `t_pca` VALUES ('230381', '虎林市', null, '1');
INSERT INTO `t_pca` VALUES ('230382', '密山市', null, '1');
INSERT INTO `t_pca` VALUES ('230400', '鹤岗市', null, '1');
INSERT INTO `t_pca` VALUES ('230402', '向阳区', null, '1');
INSERT INTO `t_pca` VALUES ('230403', '工农区', null, '1');
INSERT INTO `t_pca` VALUES ('230404', '南山区', null, '1');
INSERT INTO `t_pca` VALUES ('230405', '兴安区', null, '1');
INSERT INTO `t_pca` VALUES ('230406', '东山区', null, '1');
INSERT INTO `t_pca` VALUES ('230407', '兴山区', null, '1');
INSERT INTO `t_pca` VALUES ('230421', '萝北县', null, '1');
INSERT INTO `t_pca` VALUES ('230422', '绥滨县', null, '1');
INSERT INTO `t_pca` VALUES ('230500', '双鸭山市', null, '1');
INSERT INTO `t_pca` VALUES ('230502', '尖山区', null, '1');
INSERT INTO `t_pca` VALUES ('230503', '岭东区', null, '1');
INSERT INTO `t_pca` VALUES ('230505', '四方台区', null, '1');
INSERT INTO `t_pca` VALUES ('230506', '宝山区', null, '1');
INSERT INTO `t_pca` VALUES ('230521', '集贤县', null, '1');
INSERT INTO `t_pca` VALUES ('230522', '友谊县', null, '1');
INSERT INTO `t_pca` VALUES ('230523', '宝清县', null, '1');
INSERT INTO `t_pca` VALUES ('230524', '饶河县', null, '1');
INSERT INTO `t_pca` VALUES ('230600', '大庆市', null, '1');
INSERT INTO `t_pca` VALUES ('230602', '萨尔图区', null, '1');
INSERT INTO `t_pca` VALUES ('230603', '龙凤区', null, '1');
INSERT INTO `t_pca` VALUES ('230604', '让胡路区', null, '1');
INSERT INTO `t_pca` VALUES ('230605', '红岗区', null, '1');
INSERT INTO `t_pca` VALUES ('230606', '大同区', null, '1');
INSERT INTO `t_pca` VALUES ('230621', '肇州县', null, '1');
INSERT INTO `t_pca` VALUES ('230622', '肇源县', null, '1');
INSERT INTO `t_pca` VALUES ('230623', '林甸县', null, '1');
INSERT INTO `t_pca` VALUES ('230624', '杜尔伯特蒙古族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('230700', '伊春市', null, '1');
INSERT INTO `t_pca` VALUES ('230702', '伊春区', null, '1');
INSERT INTO `t_pca` VALUES ('230703', '南岔区', null, '1');
INSERT INTO `t_pca` VALUES ('230704', '友好区', null, '1');
INSERT INTO `t_pca` VALUES ('230705', '西林区', null, '1');
INSERT INTO `t_pca` VALUES ('230706', '翠峦区', null, '1');
INSERT INTO `t_pca` VALUES ('230707', '新青区', null, '1');
INSERT INTO `t_pca` VALUES ('230708', '美溪区', null, '1');
INSERT INTO `t_pca` VALUES ('230709', '金山屯区', null, '1');
INSERT INTO `t_pca` VALUES ('230710', '五营区', null, '1');
INSERT INTO `t_pca` VALUES ('230711', '乌马河区', null, '1');
INSERT INTO `t_pca` VALUES ('230712', '汤旺河区', null, '1');
INSERT INTO `t_pca` VALUES ('230713', '带岭区', null, '1');
INSERT INTO `t_pca` VALUES ('230714', '乌伊岭区', null, '1');
INSERT INTO `t_pca` VALUES ('230715', '红星区', null, '1');
INSERT INTO `t_pca` VALUES ('230716', '上甘岭区', null, '1');
INSERT INTO `t_pca` VALUES ('230722', '嘉荫县', null, '1');
INSERT INTO `t_pca` VALUES ('230781', '铁力市', null, '1');
INSERT INTO `t_pca` VALUES ('230800', '佳木斯市', null, '1');
INSERT INTO `t_pca` VALUES ('230803', '向阳区', null, '1');
INSERT INTO `t_pca` VALUES ('230804', '前进区', null, '1');
INSERT INTO `t_pca` VALUES ('230805', '东风区', null, '1');
INSERT INTO `t_pca` VALUES ('230811', '郊区', null, '1');
INSERT INTO `t_pca` VALUES ('230822', '桦南县', null, '1');
INSERT INTO `t_pca` VALUES ('230826', '桦川县', null, '1');
INSERT INTO `t_pca` VALUES ('230828', '汤原县', null, '1');
INSERT INTO `t_pca` VALUES ('230881', '同江市', null, '1');
INSERT INTO `t_pca` VALUES ('230882', '富锦市', null, '1');
INSERT INTO `t_pca` VALUES ('230883', '抚远市', null, '1');
INSERT INTO `t_pca` VALUES ('230900', '七台河市', null, '1');
INSERT INTO `t_pca` VALUES ('230902', '新兴区', null, '1');
INSERT INTO `t_pca` VALUES ('230903', '桃山区', null, '1');
INSERT INTO `t_pca` VALUES ('230904', '茄子河区', null, '1');
INSERT INTO `t_pca` VALUES ('230921', '勃利县', null, '1');
INSERT INTO `t_pca` VALUES ('231000', '牡丹江市', null, '1');
INSERT INTO `t_pca` VALUES ('231002', '东安区', null, '1');
INSERT INTO `t_pca` VALUES ('231003', '阳明区', null, '1');
INSERT INTO `t_pca` VALUES ('231004', '爱民区', null, '1');
INSERT INTO `t_pca` VALUES ('231005', '西安区', null, '1');
INSERT INTO `t_pca` VALUES ('231025', '林口县', null, '1');
INSERT INTO `t_pca` VALUES ('231081', '绥芬河市', null, '1');
INSERT INTO `t_pca` VALUES ('231083', '海林市', null, '1');
INSERT INTO `t_pca` VALUES ('231084', '宁安市', null, '1');
INSERT INTO `t_pca` VALUES ('231085', '穆棱市', null, '1');
INSERT INTO `t_pca` VALUES ('231086', '东宁市', null, '1');
INSERT INTO `t_pca` VALUES ('231100', '黑河市', null, '1');
INSERT INTO `t_pca` VALUES ('231102', '爱辉区', null, '1');
INSERT INTO `t_pca` VALUES ('231121', '嫩江县', null, '1');
INSERT INTO `t_pca` VALUES ('231123', '逊克县', null, '1');
INSERT INTO `t_pca` VALUES ('231124', '孙吴县', null, '1');
INSERT INTO `t_pca` VALUES ('231181', '北安市', null, '1');
INSERT INTO `t_pca` VALUES ('231182', '五大连池市', null, '1');
INSERT INTO `t_pca` VALUES ('231200', '绥化市', null, '1');
INSERT INTO `t_pca` VALUES ('231202', '北林区', null, '1');
INSERT INTO `t_pca` VALUES ('231221', '望奎县', null, '1');
INSERT INTO `t_pca` VALUES ('231222', '兰西县', null, '1');
INSERT INTO `t_pca` VALUES ('231223', '青冈县', null, '1');
INSERT INTO `t_pca` VALUES ('231224', '庆安县', null, '1');
INSERT INTO `t_pca` VALUES ('231225', '明水县', null, '1');
INSERT INTO `t_pca` VALUES ('231226', '绥棱县', null, '1');
INSERT INTO `t_pca` VALUES ('231281', '安达市', null, '1');
INSERT INTO `t_pca` VALUES ('231282', '肇东市', null, '1');
INSERT INTO `t_pca` VALUES ('231283', '海伦市', null, '1');
INSERT INTO `t_pca` VALUES ('232700', '大兴安岭地区', null, '1');
INSERT INTO `t_pca` VALUES ('232721', '呼玛县', null, '1');
INSERT INTO `t_pca` VALUES ('232722', '塔河县', null, '1');
INSERT INTO `t_pca` VALUES ('232723', '漠河县', null, '1');
INSERT INTO `t_pca` VALUES ('310000', '上海市', null, '1');
INSERT INTO `t_pca` VALUES ('310101', '黄浦区', null, '1');
INSERT INTO `t_pca` VALUES ('310104', '徐汇区', null, '1');
INSERT INTO `t_pca` VALUES ('310105', '长宁区', null, '1');
INSERT INTO `t_pca` VALUES ('310106', '静安区', null, '1');
INSERT INTO `t_pca` VALUES ('310107', '普陀区', null, '1');
INSERT INTO `t_pca` VALUES ('310109', '虹口区', null, '1');
INSERT INTO `t_pca` VALUES ('310110', '杨浦区', null, '1');
INSERT INTO `t_pca` VALUES ('310112', '闵行区', null, '1');
INSERT INTO `t_pca` VALUES ('310113', '宝山区', null, '1');
INSERT INTO `t_pca` VALUES ('310114', '嘉定区', null, '1');
INSERT INTO `t_pca` VALUES ('310115', '浦东新区', null, '1');
INSERT INTO `t_pca` VALUES ('310116', '金山区', null, '1');
INSERT INTO `t_pca` VALUES ('310117', '松江区', null, '1');
INSERT INTO `t_pca` VALUES ('310118', '青浦区', null, '1');
INSERT INTO `t_pca` VALUES ('310120', '奉贤区', null, '1');
INSERT INTO `t_pca` VALUES ('310151', '崇明区', null, '1');
INSERT INTO `t_pca` VALUES ('320000', '江苏省', null, '1');
INSERT INTO `t_pca` VALUES ('320100', '南京市', null, '1');
INSERT INTO `t_pca` VALUES ('320102', '玄武区', null, '1');
INSERT INTO `t_pca` VALUES ('320104', '秦淮区', null, '1');
INSERT INTO `t_pca` VALUES ('320105', '建邺区', null, '1');
INSERT INTO `t_pca` VALUES ('320106', '鼓楼区', null, '1');
INSERT INTO `t_pca` VALUES ('320111', '浦口区', null, '1');
INSERT INTO `t_pca` VALUES ('320113', '栖霞区', null, '1');
INSERT INTO `t_pca` VALUES ('320114', '雨花台区', null, '1');
INSERT INTO `t_pca` VALUES ('320115', '江宁区', null, '1');
INSERT INTO `t_pca` VALUES ('320116', '六合区', null, '1');
INSERT INTO `t_pca` VALUES ('320117', '溧水区', null, '1');
INSERT INTO `t_pca` VALUES ('320118', '高淳区', null, '1');
INSERT INTO `t_pca` VALUES ('320200', '无锡市', null, '1');
INSERT INTO `t_pca` VALUES ('320205', '锡山区', null, '1');
INSERT INTO `t_pca` VALUES ('320206', '惠山区', null, '1');
INSERT INTO `t_pca` VALUES ('320211', '滨湖区', null, '1');
INSERT INTO `t_pca` VALUES ('320213', '梁溪区', null, '1');
INSERT INTO `t_pca` VALUES ('320214', '新吴区', null, '1');
INSERT INTO `t_pca` VALUES ('320281', '江阴市', null, '1');
INSERT INTO `t_pca` VALUES ('320282', '宜兴市', null, '1');
INSERT INTO `t_pca` VALUES ('320300', '徐州市', null, '1');
INSERT INTO `t_pca` VALUES ('320302', '鼓楼区', null, '1');
INSERT INTO `t_pca` VALUES ('320303', '云龙区', null, '1');
INSERT INTO `t_pca` VALUES ('320305', '贾汪区', null, '1');
INSERT INTO `t_pca` VALUES ('320311', '泉山区', null, '1');
INSERT INTO `t_pca` VALUES ('320312', '铜山区', null, '1');
INSERT INTO `t_pca` VALUES ('320321', '丰县', null, '1');
INSERT INTO `t_pca` VALUES ('320322', '沛县', null, '1');
INSERT INTO `t_pca` VALUES ('320324', '睢宁县', null, '1');
INSERT INTO `t_pca` VALUES ('320381', '新沂市', null, '1');
INSERT INTO `t_pca` VALUES ('320382', '邳州市', null, '1');
INSERT INTO `t_pca` VALUES ('320400', '常州市', null, '1');
INSERT INTO `t_pca` VALUES ('320402', '天宁区', null, '1');
INSERT INTO `t_pca` VALUES ('320404', '钟楼区', null, '1');
INSERT INTO `t_pca` VALUES ('320411', '新北区', null, '1');
INSERT INTO `t_pca` VALUES ('320412', '武进区', null, '1');
INSERT INTO `t_pca` VALUES ('320413', '金坛区', null, '1');
INSERT INTO `t_pca` VALUES ('320481', '溧阳市', null, '1');
INSERT INTO `t_pca` VALUES ('320500', '苏州市', null, '1');
INSERT INTO `t_pca` VALUES ('320505', '虎丘区', null, '1');
INSERT INTO `t_pca` VALUES ('320506', '吴中区', null, '1');
INSERT INTO `t_pca` VALUES ('320507', '相城区', null, '1');
INSERT INTO `t_pca` VALUES ('320508', '姑苏区', null, '1');
INSERT INTO `t_pca` VALUES ('320509', '吴江区', null, '1');
INSERT INTO `t_pca` VALUES ('320581', '常熟市', null, '1');
INSERT INTO `t_pca` VALUES ('320582', '张家港市', null, '1');
INSERT INTO `t_pca` VALUES ('320583', '昆山市', null, '1');
INSERT INTO `t_pca` VALUES ('320585', '太仓市', null, '1');
INSERT INTO `t_pca` VALUES ('320600', '南通市', null, '1');
INSERT INTO `t_pca` VALUES ('320602', '崇川区', null, '1');
INSERT INTO `t_pca` VALUES ('320611', '港闸区', null, '1');
INSERT INTO `t_pca` VALUES ('320612', '通州区', null, '1');
INSERT INTO `t_pca` VALUES ('320621', '海安县', null, '1');
INSERT INTO `t_pca` VALUES ('320623', '如东县', null, '1');
INSERT INTO `t_pca` VALUES ('320681', '启东市', null, '1');
INSERT INTO `t_pca` VALUES ('320682', '如皋市', null, '1');
INSERT INTO `t_pca` VALUES ('320684', '海门市', null, '1');
INSERT INTO `t_pca` VALUES ('320700', '连云港市', null, '1');
INSERT INTO `t_pca` VALUES ('320703', '连云区', null, '1');
INSERT INTO `t_pca` VALUES ('320706', '海州区', null, '1');
INSERT INTO `t_pca` VALUES ('320707', '赣榆区', null, '1');
INSERT INTO `t_pca` VALUES ('320722', '东海县', null, '1');
INSERT INTO `t_pca` VALUES ('320723', '灌云县', null, '1');
INSERT INTO `t_pca` VALUES ('320724', '灌南县', null, '1');
INSERT INTO `t_pca` VALUES ('320800', '淮安市', null, '1');
INSERT INTO `t_pca` VALUES ('320803', '淮安区', null, '1');
INSERT INTO `t_pca` VALUES ('320804', '淮阴区', null, '1');
INSERT INTO `t_pca` VALUES ('320812', '清江浦区', null, '1');
INSERT INTO `t_pca` VALUES ('320813', '洪泽区', null, '1');
INSERT INTO `t_pca` VALUES ('320826', '涟水县', null, '1');
INSERT INTO `t_pca` VALUES ('320830', '盱眙县', null, '1');
INSERT INTO `t_pca` VALUES ('320831', '金湖县', null, '1');
INSERT INTO `t_pca` VALUES ('320900', '盐城市', null, '1');
INSERT INTO `t_pca` VALUES ('320902', '亭湖区', null, '1');
INSERT INTO `t_pca` VALUES ('320903', '盐都区', null, '1');
INSERT INTO `t_pca` VALUES ('320904', '大丰区', null, '1');
INSERT INTO `t_pca` VALUES ('320921', '响水县', null, '1');
INSERT INTO `t_pca` VALUES ('320922', '滨海县', null, '1');
INSERT INTO `t_pca` VALUES ('320923', '阜宁县', null, '1');
INSERT INTO `t_pca` VALUES ('320924', '射阳县', null, '1');
INSERT INTO `t_pca` VALUES ('320925', '建湖县', null, '1');
INSERT INTO `t_pca` VALUES ('320981', '东台市', null, '1');
INSERT INTO `t_pca` VALUES ('321000', '扬州市', null, '1');
INSERT INTO `t_pca` VALUES ('321002', '广陵区', null, '1');
INSERT INTO `t_pca` VALUES ('321003', '邗江区', null, '1');
INSERT INTO `t_pca` VALUES ('321012', '江都区', null, '1');
INSERT INTO `t_pca` VALUES ('321023', '宝应县', null, '1');
INSERT INTO `t_pca` VALUES ('321081', '仪征市', null, '1');
INSERT INTO `t_pca` VALUES ('321084', '高邮市', null, '1');
INSERT INTO `t_pca` VALUES ('321100', '镇江市', null, '1');
INSERT INTO `t_pca` VALUES ('321102', '京口区', null, '1');
INSERT INTO `t_pca` VALUES ('321111', '润州区', null, '1');
INSERT INTO `t_pca` VALUES ('321112', '丹徒区', null, '1');
INSERT INTO `t_pca` VALUES ('321181', '丹阳市', null, '1');
INSERT INTO `t_pca` VALUES ('321182', '扬中市', null, '1');
INSERT INTO `t_pca` VALUES ('321183', '句容市', null, '1');
INSERT INTO `t_pca` VALUES ('321200', '泰州市', null, '1');
INSERT INTO `t_pca` VALUES ('321202', '海陵区', null, '1');
INSERT INTO `t_pca` VALUES ('321203', '高港区', null, '1');
INSERT INTO `t_pca` VALUES ('321204', '姜堰区', null, '1');
INSERT INTO `t_pca` VALUES ('321281', '兴化市', null, '1');
INSERT INTO `t_pca` VALUES ('321282', '靖江市', null, '1');
INSERT INTO `t_pca` VALUES ('321283', '泰兴市', null, '1');
INSERT INTO `t_pca` VALUES ('321300', '宿迁市', null, '1');
INSERT INTO `t_pca` VALUES ('321302', '宿城区', null, '1');
INSERT INTO `t_pca` VALUES ('321311', '宿豫区', null, '1');
INSERT INTO `t_pca` VALUES ('321322', '沭阳县', null, '1');
INSERT INTO `t_pca` VALUES ('321323', '泗阳县', null, '1');
INSERT INTO `t_pca` VALUES ('321324', '泗洪县', null, '1');
INSERT INTO `t_pca` VALUES ('330000', '浙江省', null, '1');
INSERT INTO `t_pca` VALUES ('330100', '杭州市', null, '1');
INSERT INTO `t_pca` VALUES ('330102', '上城区', null, '1');
INSERT INTO `t_pca` VALUES ('330103', '下城区', null, '1');
INSERT INTO `t_pca` VALUES ('330104', '江干区', null, '1');
INSERT INTO `t_pca` VALUES ('330105', '拱墅区', null, '1');
INSERT INTO `t_pca` VALUES ('330106', '西湖区', null, '1');
INSERT INTO `t_pca` VALUES ('330108', '滨江区', null, '1');
INSERT INTO `t_pca` VALUES ('330109', '萧山区', null, '1');
INSERT INTO `t_pca` VALUES ('330110', '余杭区', null, '1');
INSERT INTO `t_pca` VALUES ('330111', '富阳区', null, '1');
INSERT INTO `t_pca` VALUES ('330112', '临安区', null, '1');
INSERT INTO `t_pca` VALUES ('330122', '桐庐县', null, '1');
INSERT INTO `t_pca` VALUES ('330127', '淳安县', null, '1');
INSERT INTO `t_pca` VALUES ('330182', '建德市', null, '1');
INSERT INTO `t_pca` VALUES ('330200', '宁波市', null, '1');
INSERT INTO `t_pca` VALUES ('330203', '海曙区', null, '1');
INSERT INTO `t_pca` VALUES ('330205', '江北区', null, '1');
INSERT INTO `t_pca` VALUES ('330206', '北仑区', null, '1');
INSERT INTO `t_pca` VALUES ('330211', '镇海区', null, '1');
INSERT INTO `t_pca` VALUES ('330212', '鄞州区', null, '1');
INSERT INTO `t_pca` VALUES ('330213', '奉化区', null, '1');
INSERT INTO `t_pca` VALUES ('330225', '象山县', null, '1');
INSERT INTO `t_pca` VALUES ('330226', '宁海县', null, '1');
INSERT INTO `t_pca` VALUES ('330281', '余姚市', null, '1');
INSERT INTO `t_pca` VALUES ('330282', '慈溪市', null, '1');
INSERT INTO `t_pca` VALUES ('330300', '温州市', null, '1');
INSERT INTO `t_pca` VALUES ('330302', '鹿城区', null, '1');
INSERT INTO `t_pca` VALUES ('330303', '龙湾区', null, '1');
INSERT INTO `t_pca` VALUES ('330304', '瓯海区', null, '1');
INSERT INTO `t_pca` VALUES ('330305', '洞头区', null, '1');
INSERT INTO `t_pca` VALUES ('330324', '永嘉县', null, '1');
INSERT INTO `t_pca` VALUES ('330326', '平阳县', null, '1');
INSERT INTO `t_pca` VALUES ('330327', '苍南县', null, '1');
INSERT INTO `t_pca` VALUES ('330328', '文成县', null, '1');
INSERT INTO `t_pca` VALUES ('330329', '泰顺县', null, '1');
INSERT INTO `t_pca` VALUES ('330381', '瑞安市', null, '1');
INSERT INTO `t_pca` VALUES ('330382', '乐清市', null, '1');
INSERT INTO `t_pca` VALUES ('330400', '嘉兴市', null, '1');
INSERT INTO `t_pca` VALUES ('330402', '南湖区', null, '1');
INSERT INTO `t_pca` VALUES ('330411', '秀洲区', null, '1');
INSERT INTO `t_pca` VALUES ('330421', '嘉善县', null, '1');
INSERT INTO `t_pca` VALUES ('330424', '海盐县', null, '1');
INSERT INTO `t_pca` VALUES ('330481', '海宁市', null, '1');
INSERT INTO `t_pca` VALUES ('330482', '平湖市', null, '1');
INSERT INTO `t_pca` VALUES ('330483', '桐乡市', null, '1');
INSERT INTO `t_pca` VALUES ('330500', '湖州市', null, '1');
INSERT INTO `t_pca` VALUES ('330502', '吴兴区', null, '1');
INSERT INTO `t_pca` VALUES ('330503', '南浔区', null, '1');
INSERT INTO `t_pca` VALUES ('330521', '德清县', null, '1');
INSERT INTO `t_pca` VALUES ('330522', '长兴县', null, '1');
INSERT INTO `t_pca` VALUES ('330523', '安吉县', null, '1');
INSERT INTO `t_pca` VALUES ('330600', '绍兴市', null, '1');
INSERT INTO `t_pca` VALUES ('330602', '越城区', null, '1');
INSERT INTO `t_pca` VALUES ('330603', '柯桥区', null, '1');
INSERT INTO `t_pca` VALUES ('330604', '上虞区', null, '1');
INSERT INTO `t_pca` VALUES ('330624', '新昌县', null, '1');
INSERT INTO `t_pca` VALUES ('330681', '诸暨市', null, '1');
INSERT INTO `t_pca` VALUES ('330683', '嵊州市', null, '1');
INSERT INTO `t_pca` VALUES ('330700', '金华市', null, '1');
INSERT INTO `t_pca` VALUES ('330702', '婺城区', null, '1');
INSERT INTO `t_pca` VALUES ('330703', '金东区', null, '1');
INSERT INTO `t_pca` VALUES ('330723', '武义县', null, '1');
INSERT INTO `t_pca` VALUES ('330726', '浦江县', null, '1');
INSERT INTO `t_pca` VALUES ('330727', '磐安县', null, '1');
INSERT INTO `t_pca` VALUES ('330781', '兰溪市', null, '1');
INSERT INTO `t_pca` VALUES ('330782', '义乌市', null, '1');
INSERT INTO `t_pca` VALUES ('330783', '东阳市', null, '1');
INSERT INTO `t_pca` VALUES ('330784', '永康市', null, '1');
INSERT INTO `t_pca` VALUES ('330800', '衢州市', null, '1');
INSERT INTO `t_pca` VALUES ('330802', '柯城区', null, '1');
INSERT INTO `t_pca` VALUES ('330803', '衢江区', null, '1');
INSERT INTO `t_pca` VALUES ('330822', '常山县', null, '1');
INSERT INTO `t_pca` VALUES ('330824', '开化县', null, '1');
INSERT INTO `t_pca` VALUES ('330825', '龙游县', null, '1');
INSERT INTO `t_pca` VALUES ('330881', '江山市', null, '1');
INSERT INTO `t_pca` VALUES ('330900', '舟山市', null, '1');
INSERT INTO `t_pca` VALUES ('330902', '定海区', null, '1');
INSERT INTO `t_pca` VALUES ('330903', '普陀区', null, '1');
INSERT INTO `t_pca` VALUES ('330921', '岱山县', null, '1');
INSERT INTO `t_pca` VALUES ('330922', '嵊泗县', null, '1');
INSERT INTO `t_pca` VALUES ('331000', '台州市', null, '1');
INSERT INTO `t_pca` VALUES ('331002', '椒江区', null, '1');
INSERT INTO `t_pca` VALUES ('331003', '黄岩区', null, '1');
INSERT INTO `t_pca` VALUES ('331004', '路桥区', null, '1');
INSERT INTO `t_pca` VALUES ('331022', '三门县', null, '1');
INSERT INTO `t_pca` VALUES ('331023', '天台县', null, '1');
INSERT INTO `t_pca` VALUES ('331024', '仙居县', null, '1');
INSERT INTO `t_pca` VALUES ('331081', '温岭市', null, '1');
INSERT INTO `t_pca` VALUES ('331082', '临海市', null, '1');
INSERT INTO `t_pca` VALUES ('331083', '玉环市', null, '1');
INSERT INTO `t_pca` VALUES ('331100', '丽水市', null, '1');
INSERT INTO `t_pca` VALUES ('331102', '莲都区', null, '1');
INSERT INTO `t_pca` VALUES ('331121', '青田县', null, '1');
INSERT INTO `t_pca` VALUES ('331122', '缙云县', null, '1');
INSERT INTO `t_pca` VALUES ('331123', '遂昌县', null, '1');
INSERT INTO `t_pca` VALUES ('331124', '松阳县', null, '1');
INSERT INTO `t_pca` VALUES ('331125', '云和县', null, '1');
INSERT INTO `t_pca` VALUES ('331126', '庆元县', null, '1');
INSERT INTO `t_pca` VALUES ('331127', '景宁畲族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('331181', '龙泉市', null, '1');
INSERT INTO `t_pca` VALUES ('340000', '安徽省', null, '1');
INSERT INTO `t_pca` VALUES ('340100', '合肥市', null, '1');
INSERT INTO `t_pca` VALUES ('340102', '瑶海区', null, '1');
INSERT INTO `t_pca` VALUES ('340103', '庐阳区', null, '1');
INSERT INTO `t_pca` VALUES ('340104', '蜀山区', null, '1');
INSERT INTO `t_pca` VALUES ('340111', '包河区', null, '1');
INSERT INTO `t_pca` VALUES ('340121', '长丰县', null, '1');
INSERT INTO `t_pca` VALUES ('340122', '肥东县', null, '1');
INSERT INTO `t_pca` VALUES ('340123', '肥西县', null, '1');
INSERT INTO `t_pca` VALUES ('340124', '庐江县', null, '1');
INSERT INTO `t_pca` VALUES ('340181', '巢湖市', null, '1');
INSERT INTO `t_pca` VALUES ('340200', '芜湖市', null, '1');
INSERT INTO `t_pca` VALUES ('340202', '镜湖区', null, '1');
INSERT INTO `t_pca` VALUES ('340203', '弋江区', null, '1');
INSERT INTO `t_pca` VALUES ('340207', '鸠江区', null, '1');
INSERT INTO `t_pca` VALUES ('340208', '三山区', null, '1');
INSERT INTO `t_pca` VALUES ('340221', '芜湖县', null, '1');
INSERT INTO `t_pca` VALUES ('340222', '繁昌县', null, '1');
INSERT INTO `t_pca` VALUES ('340223', '南陵县', null, '1');
INSERT INTO `t_pca` VALUES ('340225', '无为县', null, '1');
INSERT INTO `t_pca` VALUES ('340300', '蚌埠市', null, '1');
INSERT INTO `t_pca` VALUES ('340302', '龙子湖区', null, '1');
INSERT INTO `t_pca` VALUES ('340303', '蚌山区', null, '1');
INSERT INTO `t_pca` VALUES ('340304', '禹会区', null, '1');
INSERT INTO `t_pca` VALUES ('340311', '淮上区', null, '1');
INSERT INTO `t_pca` VALUES ('340321', '怀远县', null, '1');
INSERT INTO `t_pca` VALUES ('340322', '五河县', null, '1');
INSERT INTO `t_pca` VALUES ('340323', '固镇县', null, '1');
INSERT INTO `t_pca` VALUES ('340400', '淮南市', null, '1');
INSERT INTO `t_pca` VALUES ('340402', '大通区', null, '1');
INSERT INTO `t_pca` VALUES ('340403', '田家庵区', null, '1');
INSERT INTO `t_pca` VALUES ('340404', '谢家集区', null, '1');
INSERT INTO `t_pca` VALUES ('340405', '八公山区', null, '1');
INSERT INTO `t_pca` VALUES ('340406', '潘集区', null, '1');
INSERT INTO `t_pca` VALUES ('340421', '凤台县', null, '1');
INSERT INTO `t_pca` VALUES ('340422', '寿县', null, '1');
INSERT INTO `t_pca` VALUES ('340500', '马鞍山市', null, '1');
INSERT INTO `t_pca` VALUES ('340503', '花山区', null, '1');
INSERT INTO `t_pca` VALUES ('340504', '雨山区', null, '1');
INSERT INTO `t_pca` VALUES ('340506', '博望区', null, '1');
INSERT INTO `t_pca` VALUES ('340521', '当涂县', null, '1');
INSERT INTO `t_pca` VALUES ('340522', '含山县', null, '1');
INSERT INTO `t_pca` VALUES ('340523', '和县', null, '1');
INSERT INTO `t_pca` VALUES ('340600', '淮北市', null, '1');
INSERT INTO `t_pca` VALUES ('340602', '杜集区', null, '1');
INSERT INTO `t_pca` VALUES ('340603', '相山区', null, '1');
INSERT INTO `t_pca` VALUES ('340604', '烈山区', null, '1');
INSERT INTO `t_pca` VALUES ('340621', '濉溪县', null, '1');
INSERT INTO `t_pca` VALUES ('340700', '铜陵市', null, '1');
INSERT INTO `t_pca` VALUES ('340705', '铜官区', null, '1');
INSERT INTO `t_pca` VALUES ('340706', '义安区', null, '1');
INSERT INTO `t_pca` VALUES ('340711', '郊区', null, '1');
INSERT INTO `t_pca` VALUES ('340722', '枞阳县', null, '1');
INSERT INTO `t_pca` VALUES ('340800', '安庆市', null, '1');
INSERT INTO `t_pca` VALUES ('340802', '迎江区', null, '1');
INSERT INTO `t_pca` VALUES ('340803', '大观区', null, '1');
INSERT INTO `t_pca` VALUES ('340811', '宜秀区', null, '1');
INSERT INTO `t_pca` VALUES ('340822', '怀宁县', null, '1');
INSERT INTO `t_pca` VALUES ('340824', '潜山县', null, '1');
INSERT INTO `t_pca` VALUES ('340825', '太湖县', null, '1');
INSERT INTO `t_pca` VALUES ('340826', '宿松县', null, '1');
INSERT INTO `t_pca` VALUES ('340827', '望江县', null, '1');
INSERT INTO `t_pca` VALUES ('340828', '岳西县', null, '1');
INSERT INTO `t_pca` VALUES ('340881', '桐城市', null, '1');
INSERT INTO `t_pca` VALUES ('341000', '黄山市', null, '1');
INSERT INTO `t_pca` VALUES ('341002', '屯溪区', null, '1');
INSERT INTO `t_pca` VALUES ('341003', '黄山区', null, '1');
INSERT INTO `t_pca` VALUES ('341004', '徽州区', null, '1');
INSERT INTO `t_pca` VALUES ('341021', '歙县', null, '1');
INSERT INTO `t_pca` VALUES ('341022', '休宁县', null, '1');
INSERT INTO `t_pca` VALUES ('341023', '黟县', null, '1');
INSERT INTO `t_pca` VALUES ('341024', '祁门县', null, '1');
INSERT INTO `t_pca` VALUES ('341100', '滁州市', null, '1');
INSERT INTO `t_pca` VALUES ('341102', '琅琊区', null, '1');
INSERT INTO `t_pca` VALUES ('341103', '南谯区', null, '1');
INSERT INTO `t_pca` VALUES ('341122', '来安县', null, '1');
INSERT INTO `t_pca` VALUES ('341124', '全椒县', null, '1');
INSERT INTO `t_pca` VALUES ('341125', '定远县', null, '1');
INSERT INTO `t_pca` VALUES ('341126', '凤阳县', null, '1');
INSERT INTO `t_pca` VALUES ('341181', '天长市', null, '1');
INSERT INTO `t_pca` VALUES ('341182', '明光市', null, '1');
INSERT INTO `t_pca` VALUES ('341200', '阜阳市', null, '1');
INSERT INTO `t_pca` VALUES ('341202', '颍州区', null, '1');
INSERT INTO `t_pca` VALUES ('341203', '颍东区', null, '1');
INSERT INTO `t_pca` VALUES ('341204', '颍泉区', null, '1');
INSERT INTO `t_pca` VALUES ('341221', '临泉县', null, '1');
INSERT INTO `t_pca` VALUES ('341222', '太和县', null, '1');
INSERT INTO `t_pca` VALUES ('341225', '阜南县', null, '1');
INSERT INTO `t_pca` VALUES ('341226', '颍上县', null, '1');
INSERT INTO `t_pca` VALUES ('341282', '界首市', null, '1');
INSERT INTO `t_pca` VALUES ('341300', '宿州市', null, '1');
INSERT INTO `t_pca` VALUES ('341302', '埇桥区', null, '1');
INSERT INTO `t_pca` VALUES ('341321', '砀山县', null, '1');
INSERT INTO `t_pca` VALUES ('341322', '萧县', null, '1');
INSERT INTO `t_pca` VALUES ('341323', '灵璧县', null, '1');
INSERT INTO `t_pca` VALUES ('341324', '泗县', null, '1');
INSERT INTO `t_pca` VALUES ('341500', '六安市', null, '1');
INSERT INTO `t_pca` VALUES ('341502', '金安区', null, '1');
INSERT INTO `t_pca` VALUES ('341503', '裕安区', null, '1');
INSERT INTO `t_pca` VALUES ('341504', '叶集区', null, '1');
INSERT INTO `t_pca` VALUES ('341522', '霍邱县', null, '1');
INSERT INTO `t_pca` VALUES ('341523', '舒城县', null, '1');
INSERT INTO `t_pca` VALUES ('341524', '金寨县', null, '1');
INSERT INTO `t_pca` VALUES ('341525', '霍山县', null, '1');
INSERT INTO `t_pca` VALUES ('341600', '亳州市', null, '1');
INSERT INTO `t_pca` VALUES ('341602', '谯城区', null, '1');
INSERT INTO `t_pca` VALUES ('341621', '涡阳县', null, '1');
INSERT INTO `t_pca` VALUES ('341622', '蒙城县', null, '1');
INSERT INTO `t_pca` VALUES ('341623', '利辛县', null, '1');
INSERT INTO `t_pca` VALUES ('341700', '池州市', null, '1');
INSERT INTO `t_pca` VALUES ('341702', '贵池区', null, '1');
INSERT INTO `t_pca` VALUES ('341721', '东至县', null, '1');
INSERT INTO `t_pca` VALUES ('341722', '石台县', null, '1');
INSERT INTO `t_pca` VALUES ('341723', '青阳县', null, '1');
INSERT INTO `t_pca` VALUES ('341800', '宣城市', null, '1');
INSERT INTO `t_pca` VALUES ('341802', '宣州区', null, '1');
INSERT INTO `t_pca` VALUES ('341821', '郎溪县', null, '1');
INSERT INTO `t_pca` VALUES ('341822', '广德县', null, '1');
INSERT INTO `t_pca` VALUES ('341823', '泾县', null, '1');
INSERT INTO `t_pca` VALUES ('341824', '绩溪县', null, '1');
INSERT INTO `t_pca` VALUES ('341825', '旌德县', null, '1');
INSERT INTO `t_pca` VALUES ('341881', '宁国市', null, '1');
INSERT INTO `t_pca` VALUES ('350000', '福建省', null, '1');
INSERT INTO `t_pca` VALUES ('350100', '福州市', null, '1');
INSERT INTO `t_pca` VALUES ('350102', '鼓楼区', null, '1');
INSERT INTO `t_pca` VALUES ('350103', '台江区', null, '1');
INSERT INTO `t_pca` VALUES ('350104', '仓山区', null, '1');
INSERT INTO `t_pca` VALUES ('350105', '马尾区', null, '1');
INSERT INTO `t_pca` VALUES ('350111', '晋安区', null, '1');
INSERT INTO `t_pca` VALUES ('350112', '长乐区', null, '1');
INSERT INTO `t_pca` VALUES ('350121', '闽侯县', null, '1');
INSERT INTO `t_pca` VALUES ('350122', '连江县', null, '1');
INSERT INTO `t_pca` VALUES ('350123', '罗源县', null, '1');
INSERT INTO `t_pca` VALUES ('350124', '闽清县', null, '1');
INSERT INTO `t_pca` VALUES ('350125', '永泰县', null, '1');
INSERT INTO `t_pca` VALUES ('350128', '平潭县', null, '1');
INSERT INTO `t_pca` VALUES ('350181', '福清市', null, '1');
INSERT INTO `t_pca` VALUES ('350200', '厦门市', null, '1');
INSERT INTO `t_pca` VALUES ('350203', '思明区', null, '1');
INSERT INTO `t_pca` VALUES ('350205', '海沧区', null, '1');
INSERT INTO `t_pca` VALUES ('350206', '湖里区', null, '1');
INSERT INTO `t_pca` VALUES ('350211', '集美区', null, '1');
INSERT INTO `t_pca` VALUES ('350212', '同安区', null, '1');
INSERT INTO `t_pca` VALUES ('350213', '翔安区', null, '1');
INSERT INTO `t_pca` VALUES ('350300', '莆田市', null, '1');
INSERT INTO `t_pca` VALUES ('350302', '城厢区', null, '1');
INSERT INTO `t_pca` VALUES ('350303', '涵江区', null, '1');
INSERT INTO `t_pca` VALUES ('350304', '荔城区', null, '1');
INSERT INTO `t_pca` VALUES ('350305', '秀屿区', null, '1');
INSERT INTO `t_pca` VALUES ('350322', '仙游县', null, '1');
INSERT INTO `t_pca` VALUES ('350400', '三明市', null, '1');
INSERT INTO `t_pca` VALUES ('350402', '梅列区', null, '1');
INSERT INTO `t_pca` VALUES ('350403', '三元区', null, '1');
INSERT INTO `t_pca` VALUES ('350421', '明溪县', null, '1');
INSERT INTO `t_pca` VALUES ('350423', '清流县', null, '1');
INSERT INTO `t_pca` VALUES ('350424', '宁化县', null, '1');
INSERT INTO `t_pca` VALUES ('350425', '大田县', null, '1');
INSERT INTO `t_pca` VALUES ('350426', '尤溪县', null, '1');
INSERT INTO `t_pca` VALUES ('350427', '沙县', null, '1');
INSERT INTO `t_pca` VALUES ('350428', '将乐县', null, '1');
INSERT INTO `t_pca` VALUES ('350429', '泰宁县', null, '1');
INSERT INTO `t_pca` VALUES ('350430', '建宁县', null, '1');
INSERT INTO `t_pca` VALUES ('350481', '永安市', null, '1');
INSERT INTO `t_pca` VALUES ('350500', '泉州市', null, '1');
INSERT INTO `t_pca` VALUES ('350502', '鲤城区', null, '1');
INSERT INTO `t_pca` VALUES ('350503', '丰泽区', null, '1');
INSERT INTO `t_pca` VALUES ('350504', '洛江区', null, '1');
INSERT INTO `t_pca` VALUES ('350505', '泉港区', null, '1');
INSERT INTO `t_pca` VALUES ('350521', '惠安县', null, '1');
INSERT INTO `t_pca` VALUES ('350524', '安溪县', null, '1');
INSERT INTO `t_pca` VALUES ('350525', '永春县', null, '1');
INSERT INTO `t_pca` VALUES ('350526', '德化县', null, '1');
INSERT INTO `t_pca` VALUES ('350527', '金门县', null, '1');
INSERT INTO `t_pca` VALUES ('350581', '石狮市', null, '1');
INSERT INTO `t_pca` VALUES ('350582', '晋江市', null, '1');
INSERT INTO `t_pca` VALUES ('350583', '南安市', null, '1');
INSERT INTO `t_pca` VALUES ('350600', '漳州市', null, '1');
INSERT INTO `t_pca` VALUES ('350602', '芗城区', null, '1');
INSERT INTO `t_pca` VALUES ('350603', '龙文区', null, '1');
INSERT INTO `t_pca` VALUES ('350622', '云霄县', null, '1');
INSERT INTO `t_pca` VALUES ('350623', '漳浦县', null, '1');
INSERT INTO `t_pca` VALUES ('350624', '诏安县', null, '1');
INSERT INTO `t_pca` VALUES ('350625', '长泰县', null, '1');
INSERT INTO `t_pca` VALUES ('350626', '东山县', null, '1');
INSERT INTO `t_pca` VALUES ('350627', '南靖县', null, '1');
INSERT INTO `t_pca` VALUES ('350628', '平和县', null, '1');
INSERT INTO `t_pca` VALUES ('350629', '华安县', null, '1');
INSERT INTO `t_pca` VALUES ('350681', '龙海市', null, '1');
INSERT INTO `t_pca` VALUES ('350700', '南平市', null, '1');
INSERT INTO `t_pca` VALUES ('350702', '延平区', null, '1');
INSERT INTO `t_pca` VALUES ('350703', '建阳区', null, '1');
INSERT INTO `t_pca` VALUES ('350721', '顺昌县', null, '1');
INSERT INTO `t_pca` VALUES ('350722', '浦城县', null, '1');
INSERT INTO `t_pca` VALUES ('350723', '光泽县', null, '1');
INSERT INTO `t_pca` VALUES ('350724', '松溪县', null, '1');
INSERT INTO `t_pca` VALUES ('350725', '政和县', null, '1');
INSERT INTO `t_pca` VALUES ('350781', '邵武市', null, '1');
INSERT INTO `t_pca` VALUES ('350782', '武夷山市', null, '1');
INSERT INTO `t_pca` VALUES ('350783', '建瓯市', null, '1');
INSERT INTO `t_pca` VALUES ('350800', '龙岩市', null, '1');
INSERT INTO `t_pca` VALUES ('350802', '新罗区', null, '1');
INSERT INTO `t_pca` VALUES ('350803', '永定区', null, '1');
INSERT INTO `t_pca` VALUES ('350821', '长汀县', null, '1');
INSERT INTO `t_pca` VALUES ('350823', '上杭县', null, '1');
INSERT INTO `t_pca` VALUES ('350824', '武平县', null, '1');
INSERT INTO `t_pca` VALUES ('350825', '连城县', null, '1');
INSERT INTO `t_pca` VALUES ('350881', '漳平市', null, '1');
INSERT INTO `t_pca` VALUES ('350900', '宁德市', null, '1');
INSERT INTO `t_pca` VALUES ('350902', '蕉城区', null, '1');
INSERT INTO `t_pca` VALUES ('350921', '霞浦县', null, '1');
INSERT INTO `t_pca` VALUES ('350922', '古田县', null, '1');
INSERT INTO `t_pca` VALUES ('350923', '屏南县', null, '1');
INSERT INTO `t_pca` VALUES ('350924', '寿宁县', null, '1');
INSERT INTO `t_pca` VALUES ('350925', '周宁县', null, '1');
INSERT INTO `t_pca` VALUES ('350926', '柘荣县', null, '1');
INSERT INTO `t_pca` VALUES ('350981', '福安市', null, '1');
INSERT INTO `t_pca` VALUES ('350982', '福鼎市', null, '1');
INSERT INTO `t_pca` VALUES ('360000', '江西省', null, '1');
INSERT INTO `t_pca` VALUES ('360100', '南昌市', null, '1');
INSERT INTO `t_pca` VALUES ('360102', '东湖区', null, '1');
INSERT INTO `t_pca` VALUES ('360103', '西湖区', null, '1');
INSERT INTO `t_pca` VALUES ('360104', '青云谱区', null, '1');
INSERT INTO `t_pca` VALUES ('360105', '湾里区', null, '1');
INSERT INTO `t_pca` VALUES ('360111', '青山湖区', null, '1');
INSERT INTO `t_pca` VALUES ('360112', '新建区', null, '1');
INSERT INTO `t_pca` VALUES ('360121', '南昌县', null, '1');
INSERT INTO `t_pca` VALUES ('360123', '安义县', null, '1');
INSERT INTO `t_pca` VALUES ('360124', '进贤县', null, '1');
INSERT INTO `t_pca` VALUES ('360200', '景德镇市', null, '1');
INSERT INTO `t_pca` VALUES ('360202', '昌江区', null, '1');
INSERT INTO `t_pca` VALUES ('360203', '珠山区', null, '1');
INSERT INTO `t_pca` VALUES ('360222', '浮梁县', null, '1');
INSERT INTO `t_pca` VALUES ('360281', '乐平市', null, '1');
INSERT INTO `t_pca` VALUES ('360300', '萍乡市', null, '1');
INSERT INTO `t_pca` VALUES ('360302', '安源区', null, '1');
INSERT INTO `t_pca` VALUES ('360313', '湘东区', null, '1');
INSERT INTO `t_pca` VALUES ('360321', '莲花县', null, '1');
INSERT INTO `t_pca` VALUES ('360322', '上栗县', null, '1');
INSERT INTO `t_pca` VALUES ('360323', '芦溪县', null, '1');
INSERT INTO `t_pca` VALUES ('360400', '九江市', null, '1');
INSERT INTO `t_pca` VALUES ('360402', '濂溪区', null, '1');
INSERT INTO `t_pca` VALUES ('360403', '浔阳区', null, '1');
INSERT INTO `t_pca` VALUES ('360404', '柴桑区', null, '1');
INSERT INTO `t_pca` VALUES ('360423', '武宁县', null, '1');
INSERT INTO `t_pca` VALUES ('360424', '修水县', null, '1');
INSERT INTO `t_pca` VALUES ('360425', '永修县', null, '1');
INSERT INTO `t_pca` VALUES ('360426', '德安县', null, '1');
INSERT INTO `t_pca` VALUES ('360428', '都昌县', null, '1');
INSERT INTO `t_pca` VALUES ('360429', '湖口县', null, '1');
INSERT INTO `t_pca` VALUES ('360430', '彭泽县', null, '1');
INSERT INTO `t_pca` VALUES ('360481', '瑞昌市', null, '1');
INSERT INTO `t_pca` VALUES ('360482', '共青城市', null, '1');
INSERT INTO `t_pca` VALUES ('360483', '庐山市', null, '1');
INSERT INTO `t_pca` VALUES ('360500', '新余市', null, '1');
INSERT INTO `t_pca` VALUES ('360502', '渝水区', null, '1');
INSERT INTO `t_pca` VALUES ('360521', '分宜县', null, '1');
INSERT INTO `t_pca` VALUES ('360600', '鹰潭市', null, '1');
INSERT INTO `t_pca` VALUES ('360602', '月湖区', null, '1');
INSERT INTO `t_pca` VALUES ('360622', '余江县', null, '1');
INSERT INTO `t_pca` VALUES ('360681', '贵溪市', null, '1');
INSERT INTO `t_pca` VALUES ('360700', '赣州市', null, '1');
INSERT INTO `t_pca` VALUES ('360702', '章贡区', null, '1');
INSERT INTO `t_pca` VALUES ('360703', '南康区', null, '1');
INSERT INTO `t_pca` VALUES ('360704', '赣县区', null, '1');
INSERT INTO `t_pca` VALUES ('360722', '信丰县', null, '1');
INSERT INTO `t_pca` VALUES ('360723', '大余县', null, '1');
INSERT INTO `t_pca` VALUES ('360724', '上犹县', null, '1');
INSERT INTO `t_pca` VALUES ('360725', '崇义县', null, '1');
INSERT INTO `t_pca` VALUES ('360726', '安远县', null, '1');
INSERT INTO `t_pca` VALUES ('360727', '龙南县', null, '1');
INSERT INTO `t_pca` VALUES ('360728', '定南县', null, '1');
INSERT INTO `t_pca` VALUES ('360729', '全南县', null, '1');
INSERT INTO `t_pca` VALUES ('360730', '宁都县', null, '1');
INSERT INTO `t_pca` VALUES ('360731', '于都县', null, '1');
INSERT INTO `t_pca` VALUES ('360732', '兴国县', null, '1');
INSERT INTO `t_pca` VALUES ('360733', '会昌县', null, '1');
INSERT INTO `t_pca` VALUES ('360734', '寻乌县', null, '1');
INSERT INTO `t_pca` VALUES ('360735', '石城县', null, '1');
INSERT INTO `t_pca` VALUES ('360781', '瑞金市', null, '1');
INSERT INTO `t_pca` VALUES ('360800', '吉安市', null, '1');
INSERT INTO `t_pca` VALUES ('360802', '吉州区', null, '1');
INSERT INTO `t_pca` VALUES ('360803', '青原区', null, '1');
INSERT INTO `t_pca` VALUES ('360821', '吉安县', null, '1');
INSERT INTO `t_pca` VALUES ('360822', '吉水县', null, '1');
INSERT INTO `t_pca` VALUES ('360823', '峡江县', null, '1');
INSERT INTO `t_pca` VALUES ('360824', '新干县', null, '1');
INSERT INTO `t_pca` VALUES ('360825', '永丰县', null, '1');
INSERT INTO `t_pca` VALUES ('360826', '泰和县', null, '1');
INSERT INTO `t_pca` VALUES ('360827', '遂川县', null, '1');
INSERT INTO `t_pca` VALUES ('360828', '万安县', null, '1');
INSERT INTO `t_pca` VALUES ('360829', '安福县', null, '1');
INSERT INTO `t_pca` VALUES ('360830', '永新县', null, '1');
INSERT INTO `t_pca` VALUES ('360881', '井冈山市', null, '1');
INSERT INTO `t_pca` VALUES ('360900', '宜春市', null, '1');
INSERT INTO `t_pca` VALUES ('360902', '袁州区', null, '1');
INSERT INTO `t_pca` VALUES ('360921', '奉新县', null, '1');
INSERT INTO `t_pca` VALUES ('360922', '万载县', null, '1');
INSERT INTO `t_pca` VALUES ('360923', '上高县', null, '1');
INSERT INTO `t_pca` VALUES ('360924', '宜丰县', null, '1');
INSERT INTO `t_pca` VALUES ('360925', '靖安县', null, '1');
INSERT INTO `t_pca` VALUES ('360926', '铜鼓县', null, '1');
INSERT INTO `t_pca` VALUES ('360981', '丰城市', null, '1');
INSERT INTO `t_pca` VALUES ('360982', '樟树市', null, '1');
INSERT INTO `t_pca` VALUES ('360983', '高安市', null, '1');
INSERT INTO `t_pca` VALUES ('361000', '抚州市', null, '1');
INSERT INTO `t_pca` VALUES ('361002', '临川区', null, '1');
INSERT INTO `t_pca` VALUES ('361003', '东乡区', null, '1');
INSERT INTO `t_pca` VALUES ('361021', '南城县', null, '1');
INSERT INTO `t_pca` VALUES ('361022', '黎川县', null, '1');
INSERT INTO `t_pca` VALUES ('361023', '南丰县', null, '1');
INSERT INTO `t_pca` VALUES ('361024', '崇仁县', null, '1');
INSERT INTO `t_pca` VALUES ('361025', '乐安县', null, '1');
INSERT INTO `t_pca` VALUES ('361026', '宜黄县', null, '1');
INSERT INTO `t_pca` VALUES ('361027', '金溪县', null, '1');
INSERT INTO `t_pca` VALUES ('361028', '资溪县', null, '1');
INSERT INTO `t_pca` VALUES ('361030', '广昌县', null, '1');
INSERT INTO `t_pca` VALUES ('361100', '上饶市', null, '1');
INSERT INTO `t_pca` VALUES ('361102', '信州区', null, '1');
INSERT INTO `t_pca` VALUES ('361103', '广丰区', null, '1');
INSERT INTO `t_pca` VALUES ('361121', '上饶县', null, '1');
INSERT INTO `t_pca` VALUES ('361123', '玉山县', null, '1');
INSERT INTO `t_pca` VALUES ('361124', '铅山县', null, '1');
INSERT INTO `t_pca` VALUES ('361125', '横峰县', null, '1');
INSERT INTO `t_pca` VALUES ('361126', '弋阳县', null, '1');
INSERT INTO `t_pca` VALUES ('361127', '余干县', null, '1');
INSERT INTO `t_pca` VALUES ('361128', '鄱阳县', null, '1');
INSERT INTO `t_pca` VALUES ('361129', '万年县', null, '1');
INSERT INTO `t_pca` VALUES ('361130', '婺源县', null, '1');
INSERT INTO `t_pca` VALUES ('361181', '德兴市', null, '1');
INSERT INTO `t_pca` VALUES ('370000', '山东省', null, '1');
INSERT INTO `t_pca` VALUES ('370100', '济南市', null, '1');
INSERT INTO `t_pca` VALUES ('370102', '历下区', null, '1');
INSERT INTO `t_pca` VALUES ('370103', '市中区', null, '1');
INSERT INTO `t_pca` VALUES ('370104', '槐荫区', null, '1');
INSERT INTO `t_pca` VALUES ('370105', '天桥区', null, '1');
INSERT INTO `t_pca` VALUES ('370112', '历城区', null, '1');
INSERT INTO `t_pca` VALUES ('370113', '长清区', null, '1');
INSERT INTO `t_pca` VALUES ('370114', '章丘区', null, '1');
INSERT INTO `t_pca` VALUES ('370124', '平阴县', null, '1');
INSERT INTO `t_pca` VALUES ('370125', '济阳县', null, '1');
INSERT INTO `t_pca` VALUES ('370126', '商河县', null, '1');
INSERT INTO `t_pca` VALUES ('370200', '青岛市', null, '1');
INSERT INTO `t_pca` VALUES ('370202', '市南区', null, '1');
INSERT INTO `t_pca` VALUES ('370203', '市北区', null, '1');
INSERT INTO `t_pca` VALUES ('370211', '黄岛区', null, '1');
INSERT INTO `t_pca` VALUES ('370212', '崂山区', null, '1');
INSERT INTO `t_pca` VALUES ('370213', '李沧区', null, '1');
INSERT INTO `t_pca` VALUES ('370214', '城阳区', null, '1');
INSERT INTO `t_pca` VALUES ('370215', '即墨区', null, '1');
INSERT INTO `t_pca` VALUES ('370281', '胶州市', null, '1');
INSERT INTO `t_pca` VALUES ('370283', '平度市', null, '1');
INSERT INTO `t_pca` VALUES ('370285', '莱西市', null, '1');
INSERT INTO `t_pca` VALUES ('370300', '淄博市', null, '1');
INSERT INTO `t_pca` VALUES ('370302', '淄川区', null, '1');
INSERT INTO `t_pca` VALUES ('370303', '张店区', null, '1');
INSERT INTO `t_pca` VALUES ('370304', '博山区', null, '1');
INSERT INTO `t_pca` VALUES ('370305', '临淄区', null, '1');
INSERT INTO `t_pca` VALUES ('370306', '周村区', null, '1');
INSERT INTO `t_pca` VALUES ('370321', '桓台县', null, '1');
INSERT INTO `t_pca` VALUES ('370322', '高青县', null, '1');
INSERT INTO `t_pca` VALUES ('370323', '沂源县', null, '1');
INSERT INTO `t_pca` VALUES ('370400', '枣庄市', null, '1');
INSERT INTO `t_pca` VALUES ('370402', '市中区', null, '1');
INSERT INTO `t_pca` VALUES ('370403', '薛城区', null, '1');
INSERT INTO `t_pca` VALUES ('370404', '峄城区', null, '1');
INSERT INTO `t_pca` VALUES ('370405', '台儿庄区', null, '1');
INSERT INTO `t_pca` VALUES ('370406', '山亭区', null, '1');
INSERT INTO `t_pca` VALUES ('370481', '滕州市', null, '1');
INSERT INTO `t_pca` VALUES ('370500', '东营市', null, '1');
INSERT INTO `t_pca` VALUES ('370502', '东营区', null, '1');
INSERT INTO `t_pca` VALUES ('370503', '河口区', null, '1');
INSERT INTO `t_pca` VALUES ('370505', '垦利区', null, '1');
INSERT INTO `t_pca` VALUES ('370522', '利津县', null, '1');
INSERT INTO `t_pca` VALUES ('370523', '广饶县', null, '1');
INSERT INTO `t_pca` VALUES ('370600', '烟台市', null, '1');
INSERT INTO `t_pca` VALUES ('370602', '芝罘区', null, '1');
INSERT INTO `t_pca` VALUES ('370611', '福山区', null, '1');
INSERT INTO `t_pca` VALUES ('370612', '牟平区', null, '1');
INSERT INTO `t_pca` VALUES ('370613', '莱山区', null, '1');
INSERT INTO `t_pca` VALUES ('370634', '长岛县', null, '1');
INSERT INTO `t_pca` VALUES ('370681', '龙口市', null, '1');
INSERT INTO `t_pca` VALUES ('370682', '莱阳市', null, '1');
INSERT INTO `t_pca` VALUES ('370683', '莱州市', null, '1');
INSERT INTO `t_pca` VALUES ('370684', '蓬莱市', null, '1');
INSERT INTO `t_pca` VALUES ('370685', '招远市', null, '1');
INSERT INTO `t_pca` VALUES ('370686', '栖霞市', null, '1');
INSERT INTO `t_pca` VALUES ('370687', '海阳市', null, '1');
INSERT INTO `t_pca` VALUES ('370700', '潍坊市', null, '1');
INSERT INTO `t_pca` VALUES ('370702', '潍城区', null, '1');
INSERT INTO `t_pca` VALUES ('370703', '寒亭区', null, '1');
INSERT INTO `t_pca` VALUES ('370704', '坊子区', null, '1');
INSERT INTO `t_pca` VALUES ('370705', '奎文区', null, '1');
INSERT INTO `t_pca` VALUES ('370724', '临朐县', null, '1');
INSERT INTO `t_pca` VALUES ('370725', '昌乐县', null, '1');
INSERT INTO `t_pca` VALUES ('370781', '青州市', null, '1');
INSERT INTO `t_pca` VALUES ('370782', '诸城市', null, '1');
INSERT INTO `t_pca` VALUES ('370783', '寿光市', null, '1');
INSERT INTO `t_pca` VALUES ('370784', '安丘市', null, '1');
INSERT INTO `t_pca` VALUES ('370785', '高密市', null, '1');
INSERT INTO `t_pca` VALUES ('370786', '昌邑市', null, '1');
INSERT INTO `t_pca` VALUES ('370800', '济宁市', null, '1');
INSERT INTO `t_pca` VALUES ('370811', '任城区', null, '1');
INSERT INTO `t_pca` VALUES ('370812', '兖州区', null, '1');
INSERT INTO `t_pca` VALUES ('370826', '微山县', null, '1');
INSERT INTO `t_pca` VALUES ('370827', '鱼台县', null, '1');
INSERT INTO `t_pca` VALUES ('370828', '金乡县', null, '1');
INSERT INTO `t_pca` VALUES ('370829', '嘉祥县', null, '1');
INSERT INTO `t_pca` VALUES ('370830', '汶上县', null, '1');
INSERT INTO `t_pca` VALUES ('370831', '泗水县', null, '1');
INSERT INTO `t_pca` VALUES ('370832', '梁山县', null, '1');
INSERT INTO `t_pca` VALUES ('370881', '曲阜市', null, '1');
INSERT INTO `t_pca` VALUES ('370883', '邹城市', null, '1');
INSERT INTO `t_pca` VALUES ('370900', '泰安市', null, '1');
INSERT INTO `t_pca` VALUES ('370902', '泰山区', null, '1');
INSERT INTO `t_pca` VALUES ('370911', '岱岳区', null, '1');
INSERT INTO `t_pca` VALUES ('370921', '宁阳县', null, '1');
INSERT INTO `t_pca` VALUES ('370923', '东平县', null, '1');
INSERT INTO `t_pca` VALUES ('370982', '新泰市', null, '1');
INSERT INTO `t_pca` VALUES ('370983', '肥城市', null, '1');
INSERT INTO `t_pca` VALUES ('371000', '威海市', null, '1');
INSERT INTO `t_pca` VALUES ('371002', '环翠区', null, '1');
INSERT INTO `t_pca` VALUES ('371003', '文登区', null, '1');
INSERT INTO `t_pca` VALUES ('371082', '荣成市', null, '1');
INSERT INTO `t_pca` VALUES ('371083', '乳山市', null, '1');
INSERT INTO `t_pca` VALUES ('371100', '日照市', null, '1');
INSERT INTO `t_pca` VALUES ('371102', '东港区', null, '1');
INSERT INTO `t_pca` VALUES ('371103', '岚山区', null, '1');
INSERT INTO `t_pca` VALUES ('371121', '五莲县', null, '1');
INSERT INTO `t_pca` VALUES ('371122', '莒县', null, '1');
INSERT INTO `t_pca` VALUES ('371200', '莱芜市', null, '1');
INSERT INTO `t_pca` VALUES ('371202', '莱城区', null, '1');
INSERT INTO `t_pca` VALUES ('371203', '钢城区', null, '1');
INSERT INTO `t_pca` VALUES ('371300', '临沂市', null, '1');
INSERT INTO `t_pca` VALUES ('371302', '兰山区', null, '1');
INSERT INTO `t_pca` VALUES ('371311', '罗庄区', null, '1');
INSERT INTO `t_pca` VALUES ('371312', '河东区', null, '1');
INSERT INTO `t_pca` VALUES ('371321', '沂南县', null, '1');
INSERT INTO `t_pca` VALUES ('371322', '郯城县', null, '1');
INSERT INTO `t_pca` VALUES ('371323', '沂水县', null, '1');
INSERT INTO `t_pca` VALUES ('371324', '兰陵县', null, '1');
INSERT INTO `t_pca` VALUES ('371325', '费县', null, '1');
INSERT INTO `t_pca` VALUES ('371326', '平邑县', null, '1');
INSERT INTO `t_pca` VALUES ('371327', '莒南县', null, '1');
INSERT INTO `t_pca` VALUES ('371328', '蒙阴县', null, '1');
INSERT INTO `t_pca` VALUES ('371329', '临沭县', null, '1');
INSERT INTO `t_pca` VALUES ('371400', '德州市', null, '1');
INSERT INTO `t_pca` VALUES ('371402', '德城区', null, '1');
INSERT INTO `t_pca` VALUES ('371403', '陵城区', null, '1');
INSERT INTO `t_pca` VALUES ('371422', '宁津县', null, '1');
INSERT INTO `t_pca` VALUES ('371423', '庆云县', null, '1');
INSERT INTO `t_pca` VALUES ('371424', '临邑县', null, '1');
INSERT INTO `t_pca` VALUES ('371425', '齐河县', null, '1');
INSERT INTO `t_pca` VALUES ('371426', '平原县', null, '1');
INSERT INTO `t_pca` VALUES ('371427', '夏津县', null, '1');
INSERT INTO `t_pca` VALUES ('371428', '武城县', null, '1');
INSERT INTO `t_pca` VALUES ('371481', '乐陵市', null, '1');
INSERT INTO `t_pca` VALUES ('371482', '禹城市', null, '1');
INSERT INTO `t_pca` VALUES ('371500', '聊城市', null, '1');
INSERT INTO `t_pca` VALUES ('371502', '东昌府区', null, '1');
INSERT INTO `t_pca` VALUES ('371521', '阳谷县', null, '1');
INSERT INTO `t_pca` VALUES ('371522', '莘县', null, '1');
INSERT INTO `t_pca` VALUES ('371523', '茌平县', null, '1');
INSERT INTO `t_pca` VALUES ('371524', '东阿县', null, '1');
INSERT INTO `t_pca` VALUES ('371525', '冠县', null, '1');
INSERT INTO `t_pca` VALUES ('371526', '高唐县', null, '1');
INSERT INTO `t_pca` VALUES ('371581', '临清市', null, '1');
INSERT INTO `t_pca` VALUES ('371600', '滨州市', null, '1');
INSERT INTO `t_pca` VALUES ('371602', '滨城区', null, '1');
INSERT INTO `t_pca` VALUES ('371603', '沾化区', null, '1');
INSERT INTO `t_pca` VALUES ('371621', '惠民县', null, '1');
INSERT INTO `t_pca` VALUES ('371622', '阳信县', null, '1');
INSERT INTO `t_pca` VALUES ('371623', '无棣县', null, '1');
INSERT INTO `t_pca` VALUES ('371625', '博兴县', null, '1');
INSERT INTO `t_pca` VALUES ('371626', '邹平县', null, '1');
INSERT INTO `t_pca` VALUES ('371700', '菏泽市', null, '1');
INSERT INTO `t_pca` VALUES ('371702', '牡丹区', null, '1');
INSERT INTO `t_pca` VALUES ('371703', '定陶区', null, '1');
INSERT INTO `t_pca` VALUES ('371721', '曹县', null, '1');
INSERT INTO `t_pca` VALUES ('371722', '单县', null, '1');
INSERT INTO `t_pca` VALUES ('371723', '成武县', null, '1');
INSERT INTO `t_pca` VALUES ('371724', '巨野县', null, '1');
INSERT INTO `t_pca` VALUES ('371725', '郓城县', null, '1');
INSERT INTO `t_pca` VALUES ('371726', '鄄城县', null, '1');
INSERT INTO `t_pca` VALUES ('371728', '东明县', null, '1');
INSERT INTO `t_pca` VALUES ('410000', '河南省', null, '1');
INSERT INTO `t_pca` VALUES ('410100', '郑州市', null, '1');
INSERT INTO `t_pca` VALUES ('410102', '中原区', null, '1');
INSERT INTO `t_pca` VALUES ('410103', '二七区', null, '1');
INSERT INTO `t_pca` VALUES ('410104', '管城回族区', null, '1');
INSERT INTO `t_pca` VALUES ('410105', '金水区', null, '1');
INSERT INTO `t_pca` VALUES ('410106', '上街区', null, '1');
INSERT INTO `t_pca` VALUES ('410108', '惠济区', null, '1');
INSERT INTO `t_pca` VALUES ('410122', '中牟县', null, '1');
INSERT INTO `t_pca` VALUES ('410181', '巩义市', null, '1');
INSERT INTO `t_pca` VALUES ('410182', '荥阳市', null, '1');
INSERT INTO `t_pca` VALUES ('410183', '新密市', null, '1');
INSERT INTO `t_pca` VALUES ('410184', '新郑市', null, '1');
INSERT INTO `t_pca` VALUES ('410185', '登封市', null, '1');
INSERT INTO `t_pca` VALUES ('410200', '开封市', null, '1');
INSERT INTO `t_pca` VALUES ('410202', '龙亭区', null, '1');
INSERT INTO `t_pca` VALUES ('410203', '顺河回族区', null, '1');
INSERT INTO `t_pca` VALUES ('410204', '鼓楼区', null, '1');
INSERT INTO `t_pca` VALUES ('410205', '禹王台区', null, '1');
INSERT INTO `t_pca` VALUES ('410212', '祥符区', null, '1');
INSERT INTO `t_pca` VALUES ('410221', '杞县', null, '1');
INSERT INTO `t_pca` VALUES ('410222', '通许县', null, '1');
INSERT INTO `t_pca` VALUES ('410223', '尉氏县', null, '1');
INSERT INTO `t_pca` VALUES ('410225', '兰考县', null, '1');
INSERT INTO `t_pca` VALUES ('410300', '洛阳市', null, '1');
INSERT INTO `t_pca` VALUES ('410302', '老城区', null, '1');
INSERT INTO `t_pca` VALUES ('410303', '西工区', null, '1');
INSERT INTO `t_pca` VALUES ('410304', '瀍河回族区', null, '1');
INSERT INTO `t_pca` VALUES ('410305', '涧西区', null, '1');
INSERT INTO `t_pca` VALUES ('410306', '吉利区', null, '1');
INSERT INTO `t_pca` VALUES ('410311', '洛龙区', null, '1');
INSERT INTO `t_pca` VALUES ('410322', '孟津县', null, '1');
INSERT INTO `t_pca` VALUES ('410323', '新安县', null, '1');
INSERT INTO `t_pca` VALUES ('410324', '栾川县', null, '1');
INSERT INTO `t_pca` VALUES ('410325', '嵩县', null, '1');
INSERT INTO `t_pca` VALUES ('410326', '汝阳县', null, '1');
INSERT INTO `t_pca` VALUES ('410327', '宜阳县', null, '1');
INSERT INTO `t_pca` VALUES ('410328', '洛宁县', null, '1');
INSERT INTO `t_pca` VALUES ('410329', '伊川县', null, '1');
INSERT INTO `t_pca` VALUES ('410381', '偃师市', null, '1');
INSERT INTO `t_pca` VALUES ('410400', '平顶山市', null, '1');
INSERT INTO `t_pca` VALUES ('410402', '新华区', null, '1');
INSERT INTO `t_pca` VALUES ('410403', '卫东区', null, '1');
INSERT INTO `t_pca` VALUES ('410404', '石龙区', null, '1');
INSERT INTO `t_pca` VALUES ('410411', '湛河区', null, '1');
INSERT INTO `t_pca` VALUES ('410421', '宝丰县', null, '1');
INSERT INTO `t_pca` VALUES ('410422', '叶县', null, '1');
INSERT INTO `t_pca` VALUES ('410423', '鲁山县', null, '1');
INSERT INTO `t_pca` VALUES ('410425', '郏县', null, '1');
INSERT INTO `t_pca` VALUES ('410481', '舞钢市', null, '1');
INSERT INTO `t_pca` VALUES ('410482', '汝州市', null, '1');
INSERT INTO `t_pca` VALUES ('410500', '安阳市', null, '1');
INSERT INTO `t_pca` VALUES ('410502', '文峰区', null, '1');
INSERT INTO `t_pca` VALUES ('410503', '北关区', null, '1');
INSERT INTO `t_pca` VALUES ('410505', '殷都区', null, '1');
INSERT INTO `t_pca` VALUES ('410506', '龙安区', null, '1');
INSERT INTO `t_pca` VALUES ('410522', '安阳县', null, '1');
INSERT INTO `t_pca` VALUES ('410523', '汤阴县', null, '1');
INSERT INTO `t_pca` VALUES ('410526', '滑县', null, '1');
INSERT INTO `t_pca` VALUES ('410527', '内黄县', null, '1');
INSERT INTO `t_pca` VALUES ('410581', '林州市', null, '1');
INSERT INTO `t_pca` VALUES ('410600', '鹤壁市', null, '1');
INSERT INTO `t_pca` VALUES ('410602', '鹤山区', null, '1');
INSERT INTO `t_pca` VALUES ('410603', '山城区', null, '1');
INSERT INTO `t_pca` VALUES ('410611', '淇滨区', null, '1');
INSERT INTO `t_pca` VALUES ('410621', '浚县', null, '1');
INSERT INTO `t_pca` VALUES ('410622', '淇县', null, '1');
INSERT INTO `t_pca` VALUES ('410700', '新乡市', null, '1');
INSERT INTO `t_pca` VALUES ('410702', '红旗区', null, '1');
INSERT INTO `t_pca` VALUES ('410703', '卫滨区', null, '1');
INSERT INTO `t_pca` VALUES ('410704', '凤泉区', null, '1');
INSERT INTO `t_pca` VALUES ('410711', '牧野区', null, '1');
INSERT INTO `t_pca` VALUES ('410721', '新乡县', null, '1');
INSERT INTO `t_pca` VALUES ('410724', '获嘉县', null, '1');
INSERT INTO `t_pca` VALUES ('410725', '原阳县', null, '1');
INSERT INTO `t_pca` VALUES ('410726', '延津县', null, '1');
INSERT INTO `t_pca` VALUES ('410727', '封丘县', null, '1');
INSERT INTO `t_pca` VALUES ('410728', '长垣县', null, '1');
INSERT INTO `t_pca` VALUES ('410781', '卫辉市', null, '1');
INSERT INTO `t_pca` VALUES ('410782', '辉县市', null, '1');
INSERT INTO `t_pca` VALUES ('410800', '焦作市', null, '1');
INSERT INTO `t_pca` VALUES ('410802', '解放区', null, '1');
INSERT INTO `t_pca` VALUES ('410803', '中站区', null, '1');
INSERT INTO `t_pca` VALUES ('410804', '马村区', null, '1');
INSERT INTO `t_pca` VALUES ('410811', '山阳区', null, '1');
INSERT INTO `t_pca` VALUES ('410821', '修武县', null, '1');
INSERT INTO `t_pca` VALUES ('410822', '博爱县', null, '1');
INSERT INTO `t_pca` VALUES ('410823', '武陟县', null, '1');
INSERT INTO `t_pca` VALUES ('410825', '温县', null, '1');
INSERT INTO `t_pca` VALUES ('410882', '沁阳市', null, '1');
INSERT INTO `t_pca` VALUES ('410883', '孟州市', null, '1');
INSERT INTO `t_pca` VALUES ('410900', '濮阳市', null, '1');
INSERT INTO `t_pca` VALUES ('410902', '华龙区', null, '1');
INSERT INTO `t_pca` VALUES ('410922', '清丰县', null, '1');
INSERT INTO `t_pca` VALUES ('410923', '南乐县', null, '1');
INSERT INTO `t_pca` VALUES ('410926', '范县', null, '1');
INSERT INTO `t_pca` VALUES ('410927', '台前县', null, '1');
INSERT INTO `t_pca` VALUES ('410928', '濮阳县', null, '1');
INSERT INTO `t_pca` VALUES ('411000', '许昌市', null, '1');
INSERT INTO `t_pca` VALUES ('411002', '魏都区', null, '1');
INSERT INTO `t_pca` VALUES ('411003', '建安区', null, '1');
INSERT INTO `t_pca` VALUES ('411024', '鄢陵县', null, '1');
INSERT INTO `t_pca` VALUES ('411025', '襄城县', null, '1');
INSERT INTO `t_pca` VALUES ('411081', '禹州市', null, '1');
INSERT INTO `t_pca` VALUES ('411082', '长葛市', null, '1');
INSERT INTO `t_pca` VALUES ('411100', '漯河市', null, '1');
INSERT INTO `t_pca` VALUES ('411102', '源汇区', null, '1');
INSERT INTO `t_pca` VALUES ('411103', '郾城区', null, '1');
INSERT INTO `t_pca` VALUES ('411104', '召陵区', null, '1');
INSERT INTO `t_pca` VALUES ('411121', '舞阳县', null, '1');
INSERT INTO `t_pca` VALUES ('411122', '临颍县', null, '1');
INSERT INTO `t_pca` VALUES ('411200', '三门峡市', null, '1');
INSERT INTO `t_pca` VALUES ('411202', '湖滨区', null, '1');
INSERT INTO `t_pca` VALUES ('411203', '陕州区', null, '1');
INSERT INTO `t_pca` VALUES ('411221', '渑池县', null, '1');
INSERT INTO `t_pca` VALUES ('411224', '卢氏县', null, '1');
INSERT INTO `t_pca` VALUES ('411281', '义马市', null, '1');
INSERT INTO `t_pca` VALUES ('411282', '灵宝市', null, '1');
INSERT INTO `t_pca` VALUES ('411300', '南阳市', null, '1');
INSERT INTO `t_pca` VALUES ('411302', '宛城区', null, '1');
INSERT INTO `t_pca` VALUES ('411303', '卧龙区', null, '1');
INSERT INTO `t_pca` VALUES ('411321', '南召县', null, '1');
INSERT INTO `t_pca` VALUES ('411322', '方城县', null, '1');
INSERT INTO `t_pca` VALUES ('411323', '西峡县', null, '1');
INSERT INTO `t_pca` VALUES ('411324', '镇平县', null, '1');
INSERT INTO `t_pca` VALUES ('411325', '内乡县', null, '1');
INSERT INTO `t_pca` VALUES ('411326', '淅川县', null, '1');
INSERT INTO `t_pca` VALUES ('411327', '社旗县', null, '1');
INSERT INTO `t_pca` VALUES ('411328', '唐河县', null, '1');
INSERT INTO `t_pca` VALUES ('411329', '新野县', null, '1');
INSERT INTO `t_pca` VALUES ('411330', '桐柏县', null, '1');
INSERT INTO `t_pca` VALUES ('411381', '邓州市', null, '1');
INSERT INTO `t_pca` VALUES ('411400', '商丘市', null, '1');
INSERT INTO `t_pca` VALUES ('411402', '梁园区', null, '1');
INSERT INTO `t_pca` VALUES ('411403', '睢阳区', null, '1');
INSERT INTO `t_pca` VALUES ('411421', '民权县', null, '1');
INSERT INTO `t_pca` VALUES ('411422', '睢县', null, '1');
INSERT INTO `t_pca` VALUES ('411423', '宁陵县', null, '1');
INSERT INTO `t_pca` VALUES ('411424', '柘城县', null, '1');
INSERT INTO `t_pca` VALUES ('411425', '虞城县', null, '1');
INSERT INTO `t_pca` VALUES ('411426', '夏邑县', null, '1');
INSERT INTO `t_pca` VALUES ('411481', '永城市', null, '1');
INSERT INTO `t_pca` VALUES ('411500', '信阳市', null, '1');
INSERT INTO `t_pca` VALUES ('411502', '浉河区', null, '1');
INSERT INTO `t_pca` VALUES ('411503', '平桥区', null, '1');
INSERT INTO `t_pca` VALUES ('411521', '罗山县', null, '1');
INSERT INTO `t_pca` VALUES ('411522', '光山县', null, '1');
INSERT INTO `t_pca` VALUES ('411523', '新县', null, '1');
INSERT INTO `t_pca` VALUES ('411524', '商城县', null, '1');
INSERT INTO `t_pca` VALUES ('411525', '固始县', null, '1');
INSERT INTO `t_pca` VALUES ('411526', '潢川县', null, '1');
INSERT INTO `t_pca` VALUES ('411527', '淮滨县', null, '1');
INSERT INTO `t_pca` VALUES ('411528', '息县', null, '1');
INSERT INTO `t_pca` VALUES ('411600', '周口市', null, '1');
INSERT INTO `t_pca` VALUES ('411602', '川汇区', null, '1');
INSERT INTO `t_pca` VALUES ('411621', '扶沟县', null, '1');
INSERT INTO `t_pca` VALUES ('411622', '西华县', null, '1');
INSERT INTO `t_pca` VALUES ('411623', '商水县', null, '1');
INSERT INTO `t_pca` VALUES ('411624', '沈丘县', null, '1');
INSERT INTO `t_pca` VALUES ('411625', '郸城县', null, '1');
INSERT INTO `t_pca` VALUES ('411626', '淮阳县', null, '1');
INSERT INTO `t_pca` VALUES ('411627', '太康县', null, '1');
INSERT INTO `t_pca` VALUES ('411628', '鹿邑县', null, '1');
INSERT INTO `t_pca` VALUES ('411681', '项城市', null, '1');
INSERT INTO `t_pca` VALUES ('411700', '驻马店市', null, '1');
INSERT INTO `t_pca` VALUES ('411702', '驿城区', null, '1');
INSERT INTO `t_pca` VALUES ('411721', '西平县', null, '1');
INSERT INTO `t_pca` VALUES ('411722', '上蔡县', null, '1');
INSERT INTO `t_pca` VALUES ('411723', '平舆县', null, '1');
INSERT INTO `t_pca` VALUES ('411724', '正阳县', null, '1');
INSERT INTO `t_pca` VALUES ('411725', '确山县', null, '1');
INSERT INTO `t_pca` VALUES ('411726', '泌阳县', null, '1');
INSERT INTO `t_pca` VALUES ('411727', '汝南县', null, '1');
INSERT INTO `t_pca` VALUES ('411728', '遂平县', null, '1');
INSERT INTO `t_pca` VALUES ('411729', '新蔡县', null, '1');
INSERT INTO `t_pca` VALUES ('419001', '济源市', null, '1');
INSERT INTO `t_pca` VALUES ('420000', '湖北省', null, '1');
INSERT INTO `t_pca` VALUES ('420100', '武汉市', null, '1');
INSERT INTO `t_pca` VALUES ('420102', '江岸区', null, '1');
INSERT INTO `t_pca` VALUES ('420103', '江汉区', null, '1');
INSERT INTO `t_pca` VALUES ('420104', '硚口区', null, '1');
INSERT INTO `t_pca` VALUES ('420105', '汉阳区', null, '1');
INSERT INTO `t_pca` VALUES ('420106', '武昌区', null, '1');
INSERT INTO `t_pca` VALUES ('420107', '青山区', null, '1');
INSERT INTO `t_pca` VALUES ('420111', '洪山区', null, '1');
INSERT INTO `t_pca` VALUES ('420112', '东西湖区', null, '1');
INSERT INTO `t_pca` VALUES ('420113', '汉南区', null, '1');
INSERT INTO `t_pca` VALUES ('420114', '蔡甸区', null, '1');
INSERT INTO `t_pca` VALUES ('420115', '江夏区', null, '1');
INSERT INTO `t_pca` VALUES ('420116', '黄陂区', null, '1');
INSERT INTO `t_pca` VALUES ('420117', '新洲区', null, '1');
INSERT INTO `t_pca` VALUES ('420200', '黄石市', null, '1');
INSERT INTO `t_pca` VALUES ('420202', '黄石港区', null, '1');
INSERT INTO `t_pca` VALUES ('420203', '西塞山区', null, '1');
INSERT INTO `t_pca` VALUES ('420204', '下陆区', null, '1');
INSERT INTO `t_pca` VALUES ('420205', '铁山区', null, '1');
INSERT INTO `t_pca` VALUES ('420222', '阳新县', null, '1');
INSERT INTO `t_pca` VALUES ('420281', '大冶市', null, '1');
INSERT INTO `t_pca` VALUES ('420300', '十堰市', null, '1');
INSERT INTO `t_pca` VALUES ('420302', '茅箭区', null, '1');
INSERT INTO `t_pca` VALUES ('420303', '张湾区', null, '1');
INSERT INTO `t_pca` VALUES ('420304', '郧阳区', null, '1');
INSERT INTO `t_pca` VALUES ('420322', '郧西县', null, '1');
INSERT INTO `t_pca` VALUES ('420323', '竹山县', null, '1');
INSERT INTO `t_pca` VALUES ('420324', '竹溪县', null, '1');
INSERT INTO `t_pca` VALUES ('420325', '房县', null, '1');
INSERT INTO `t_pca` VALUES ('420381', '丹江口市', null, '1');
INSERT INTO `t_pca` VALUES ('420500', '宜昌市', null, '1');
INSERT INTO `t_pca` VALUES ('420502', '西陵区', null, '1');
INSERT INTO `t_pca` VALUES ('420503', '伍家岗区', null, '1');
INSERT INTO `t_pca` VALUES ('420504', '点军区', null, '1');
INSERT INTO `t_pca` VALUES ('420505', '猇亭区', null, '1');
INSERT INTO `t_pca` VALUES ('420506', '夷陵区', null, '1');
INSERT INTO `t_pca` VALUES ('420525', '远安县', null, '1');
INSERT INTO `t_pca` VALUES ('420526', '兴山县', null, '1');
INSERT INTO `t_pca` VALUES ('420527', '秭归县', null, '1');
INSERT INTO `t_pca` VALUES ('420528', '长阳土家族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('420529', '五峰土家族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('420581', '宜都市', null, '1');
INSERT INTO `t_pca` VALUES ('420582', '当阳市', null, '1');
INSERT INTO `t_pca` VALUES ('420583', '枝江市', null, '1');
INSERT INTO `t_pca` VALUES ('420600', '襄阳市', null, '1');
INSERT INTO `t_pca` VALUES ('420602', '襄城区', null, '1');
INSERT INTO `t_pca` VALUES ('420606', '樊城区', null, '1');
INSERT INTO `t_pca` VALUES ('420607', '襄州区', null, '1');
INSERT INTO `t_pca` VALUES ('420624', '南漳县', null, '1');
INSERT INTO `t_pca` VALUES ('420625', '谷城县', null, '1');
INSERT INTO `t_pca` VALUES ('420626', '保康县', null, '1');
INSERT INTO `t_pca` VALUES ('420682', '老河口市', null, '1');
INSERT INTO `t_pca` VALUES ('420683', '枣阳市', null, '1');
INSERT INTO `t_pca` VALUES ('420684', '宜城市', null, '1');
INSERT INTO `t_pca` VALUES ('420700', '鄂州市', null, '1');
INSERT INTO `t_pca` VALUES ('420702', '梁子湖区', null, '1');
INSERT INTO `t_pca` VALUES ('420703', '华容区', null, '1');
INSERT INTO `t_pca` VALUES ('420704', '鄂城区', null, '1');
INSERT INTO `t_pca` VALUES ('420800', '荆门市', null, '1');
INSERT INTO `t_pca` VALUES ('420802', '东宝区', null, '1');
INSERT INTO `t_pca` VALUES ('420804', '掇刀区', null, '1');
INSERT INTO `t_pca` VALUES ('420821', '京山县', null, '1');
INSERT INTO `t_pca` VALUES ('420822', '沙洋县', null, '1');
INSERT INTO `t_pca` VALUES ('420881', '钟祥市', null, '1');
INSERT INTO `t_pca` VALUES ('420900', '孝感市', null, '1');
INSERT INTO `t_pca` VALUES ('420902', '孝南区', null, '1');
INSERT INTO `t_pca` VALUES ('420921', '孝昌县', null, '1');
INSERT INTO `t_pca` VALUES ('420922', '大悟县', null, '1');
INSERT INTO `t_pca` VALUES ('420923', '云梦县', null, '1');
INSERT INTO `t_pca` VALUES ('420981', '应城市', null, '1');
INSERT INTO `t_pca` VALUES ('420982', '安陆市', null, '1');
INSERT INTO `t_pca` VALUES ('420984', '汉川市', null, '1');
INSERT INTO `t_pca` VALUES ('421000', '荆州市', null, '1');
INSERT INTO `t_pca` VALUES ('421002', '沙市区', null, '1');
INSERT INTO `t_pca` VALUES ('421003', '荆州区', null, '1');
INSERT INTO `t_pca` VALUES ('421022', '公安县', null, '1');
INSERT INTO `t_pca` VALUES ('421023', '监利县', null, '1');
INSERT INTO `t_pca` VALUES ('421024', '江陵县', null, '1');
INSERT INTO `t_pca` VALUES ('421081', '石首市', null, '1');
INSERT INTO `t_pca` VALUES ('421083', '洪湖市', null, '1');
INSERT INTO `t_pca` VALUES ('421087', '松滋市', null, '1');
INSERT INTO `t_pca` VALUES ('421100', '黄冈市', null, '1');
INSERT INTO `t_pca` VALUES ('421102', '黄州区', null, '1');
INSERT INTO `t_pca` VALUES ('421121', '团风县', null, '1');
INSERT INTO `t_pca` VALUES ('421122', '红安县', null, '1');
INSERT INTO `t_pca` VALUES ('421123', '罗田县', null, '1');
INSERT INTO `t_pca` VALUES ('421124', '英山县', null, '1');
INSERT INTO `t_pca` VALUES ('421125', '浠水县', null, '1');
INSERT INTO `t_pca` VALUES ('421126', '蕲春县', null, '1');
INSERT INTO `t_pca` VALUES ('421127', '黄梅县', null, '1');
INSERT INTO `t_pca` VALUES ('421181', '麻城市', null, '1');
INSERT INTO `t_pca` VALUES ('421182', '武穴市', null, '1');
INSERT INTO `t_pca` VALUES ('421200', '咸宁市', null, '1');
INSERT INTO `t_pca` VALUES ('421202', '咸安区', null, '1');
INSERT INTO `t_pca` VALUES ('421221', '嘉鱼县', null, '1');
INSERT INTO `t_pca` VALUES ('421222', '通城县', null, '1');
INSERT INTO `t_pca` VALUES ('421223', '崇阳县', null, '1');
INSERT INTO `t_pca` VALUES ('421224', '通山县', null, '1');
INSERT INTO `t_pca` VALUES ('421281', '赤壁市', null, '1');
INSERT INTO `t_pca` VALUES ('421300', '随州市', null, '1');
INSERT INTO `t_pca` VALUES ('421303', '曾都区', null, '1');
INSERT INTO `t_pca` VALUES ('421321', '随县', null, '1');
INSERT INTO `t_pca` VALUES ('421381', '广水市', null, '1');
INSERT INTO `t_pca` VALUES ('422800', '恩施土家族苗族自治州', null, '1');
INSERT INTO `t_pca` VALUES ('422801', '恩施市', null, '1');
INSERT INTO `t_pca` VALUES ('422802', '利川市', null, '1');
INSERT INTO `t_pca` VALUES ('422822', '建始县', null, '1');
INSERT INTO `t_pca` VALUES ('422823', '巴东县', null, '1');
INSERT INTO `t_pca` VALUES ('422825', '宣恩县', null, '1');
INSERT INTO `t_pca` VALUES ('422826', '咸丰县', null, '1');
INSERT INTO `t_pca` VALUES ('422827', '来凤县', null, '1');
INSERT INTO `t_pca` VALUES ('422828', '鹤峰县', null, '1');
INSERT INTO `t_pca` VALUES ('429004', '仙桃市', null, '1');
INSERT INTO `t_pca` VALUES ('429005', '潜江市', null, '1');
INSERT INTO `t_pca` VALUES ('429006', '天门市', null, '1');
INSERT INTO `t_pca` VALUES ('429021', '神农架林区', null, '1');
INSERT INTO `t_pca` VALUES ('430000', '湖南省', null, '1');
INSERT INTO `t_pca` VALUES ('430100', '长沙市', null, '1');
INSERT INTO `t_pca` VALUES ('430102', '芙蓉区', null, '1');
INSERT INTO `t_pca` VALUES ('430103', '天心区', null, '1');
INSERT INTO `t_pca` VALUES ('430104', '岳麓区', null, '1');
INSERT INTO `t_pca` VALUES ('430105', '开福区', null, '1');
INSERT INTO `t_pca` VALUES ('430111', '雨花区', null, '1');
INSERT INTO `t_pca` VALUES ('430112', '望城区', null, '1');
INSERT INTO `t_pca` VALUES ('430121', '长沙县', null, '1');
INSERT INTO `t_pca` VALUES ('430181', '浏阳市', null, '1');
INSERT INTO `t_pca` VALUES ('430182', '宁乡市', null, '1');
INSERT INTO `t_pca` VALUES ('430200', '株洲市', null, '1');
INSERT INTO `t_pca` VALUES ('430202', '荷塘区', null, '1');
INSERT INTO `t_pca` VALUES ('430203', '芦淞区', null, '1');
INSERT INTO `t_pca` VALUES ('430204', '石峰区', null, '1');
INSERT INTO `t_pca` VALUES ('430211', '天元区', null, '1');
INSERT INTO `t_pca` VALUES ('430221', '株洲县', null, '1');
INSERT INTO `t_pca` VALUES ('430223', '攸县', null, '1');
INSERT INTO `t_pca` VALUES ('430224', '茶陵县', null, '1');
INSERT INTO `t_pca` VALUES ('430225', '炎陵县', null, '1');
INSERT INTO `t_pca` VALUES ('430281', '醴陵市', null, '1');
INSERT INTO `t_pca` VALUES ('430300', '湘潭市', null, '1');
INSERT INTO `t_pca` VALUES ('430302', '雨湖区', null, '1');
INSERT INTO `t_pca` VALUES ('430304', '岳塘区', null, '1');
INSERT INTO `t_pca` VALUES ('430321', '湘潭县', null, '1');
INSERT INTO `t_pca` VALUES ('430381', '湘乡市', null, '1');
INSERT INTO `t_pca` VALUES ('430382', '韶山市', null, '1');
INSERT INTO `t_pca` VALUES ('430400', '衡阳市', null, '1');
INSERT INTO `t_pca` VALUES ('430405', '珠晖区', null, '1');
INSERT INTO `t_pca` VALUES ('430406', '雁峰区', null, '1');
INSERT INTO `t_pca` VALUES ('430407', '石鼓区', null, '1');
INSERT INTO `t_pca` VALUES ('430408', '蒸湘区', null, '1');
INSERT INTO `t_pca` VALUES ('430412', '南岳区', null, '1');
INSERT INTO `t_pca` VALUES ('430421', '衡阳县', null, '1');
INSERT INTO `t_pca` VALUES ('430422', '衡南县', null, '1');
INSERT INTO `t_pca` VALUES ('430423', '衡山县', null, '1');
INSERT INTO `t_pca` VALUES ('430424', '衡东县', null, '1');
INSERT INTO `t_pca` VALUES ('430426', '祁东县', null, '1');
INSERT INTO `t_pca` VALUES ('430481', '耒阳市', null, '1');
INSERT INTO `t_pca` VALUES ('430482', '常宁市', null, '1');
INSERT INTO `t_pca` VALUES ('430500', '邵阳市', null, '1');
INSERT INTO `t_pca` VALUES ('430502', '双清区', null, '1');
INSERT INTO `t_pca` VALUES ('430503', '大祥区', null, '1');
INSERT INTO `t_pca` VALUES ('430511', '北塔区', null, '1');
INSERT INTO `t_pca` VALUES ('430521', '邵东县', null, '1');
INSERT INTO `t_pca` VALUES ('430522', '新邵县', null, '1');
INSERT INTO `t_pca` VALUES ('430523', '邵阳县', null, '1');
INSERT INTO `t_pca` VALUES ('430524', '隆回县', null, '1');
INSERT INTO `t_pca` VALUES ('430525', '洞口县', null, '1');
INSERT INTO `t_pca` VALUES ('430527', '绥宁县', null, '1');
INSERT INTO `t_pca` VALUES ('430528', '新宁县', null, '1');
INSERT INTO `t_pca` VALUES ('430529', '城步苗族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('430581', '武冈市', null, '1');
INSERT INTO `t_pca` VALUES ('430600', '岳阳市', null, '1');
INSERT INTO `t_pca` VALUES ('430602', '岳阳楼区', null, '1');
INSERT INTO `t_pca` VALUES ('430603', '云溪区', null, '1');
INSERT INTO `t_pca` VALUES ('430611', '君山区', null, '1');
INSERT INTO `t_pca` VALUES ('430621', '岳阳县', null, '1');
INSERT INTO `t_pca` VALUES ('430623', '华容县', null, '1');
INSERT INTO `t_pca` VALUES ('430624', '湘阴县', null, '1');
INSERT INTO `t_pca` VALUES ('430626', '平江县', null, '1');
INSERT INTO `t_pca` VALUES ('430681', '汨罗市', null, '1');
INSERT INTO `t_pca` VALUES ('430682', '临湘市', null, '1');
INSERT INTO `t_pca` VALUES ('430700', '常德市', null, '1');
INSERT INTO `t_pca` VALUES ('430702', '武陵区', null, '1');
INSERT INTO `t_pca` VALUES ('430703', '鼎城区', null, '1');
INSERT INTO `t_pca` VALUES ('430721', '安乡县', null, '1');
INSERT INTO `t_pca` VALUES ('430722', '汉寿县', null, '1');
INSERT INTO `t_pca` VALUES ('430723', '澧县', null, '1');
INSERT INTO `t_pca` VALUES ('430724', '临澧县', null, '1');
INSERT INTO `t_pca` VALUES ('430725', '桃源县', null, '1');
INSERT INTO `t_pca` VALUES ('430726', '石门县', null, '1');
INSERT INTO `t_pca` VALUES ('430781', '津市市', null, '1');
INSERT INTO `t_pca` VALUES ('430800', '张家界市', null, '1');
INSERT INTO `t_pca` VALUES ('430802', '永定区', null, '1');
INSERT INTO `t_pca` VALUES ('430811', '武陵源区', null, '1');
INSERT INTO `t_pca` VALUES ('430821', '慈利县', null, '1');
INSERT INTO `t_pca` VALUES ('430822', '桑植县', null, '1');
INSERT INTO `t_pca` VALUES ('430900', '益阳市', null, '1');
INSERT INTO `t_pca` VALUES ('430902', '资阳区', null, '1');
INSERT INTO `t_pca` VALUES ('430903', '赫山区', null, '1');
INSERT INTO `t_pca` VALUES ('430921', '南县', null, '1');
INSERT INTO `t_pca` VALUES ('430922', '桃江县', null, '1');
INSERT INTO `t_pca` VALUES ('430923', '安化县', null, '1');
INSERT INTO `t_pca` VALUES ('430981', '沅江市', null, '1');
INSERT INTO `t_pca` VALUES ('431000', '郴州市', null, '1');
INSERT INTO `t_pca` VALUES ('431002', '北湖区', null, '1');
INSERT INTO `t_pca` VALUES ('431003', '苏仙区', null, '1');
INSERT INTO `t_pca` VALUES ('431021', '桂阳县', null, '1');
INSERT INTO `t_pca` VALUES ('431022', '宜章县', null, '1');
INSERT INTO `t_pca` VALUES ('431023', '永兴县', null, '1');
INSERT INTO `t_pca` VALUES ('431024', '嘉禾县', null, '1');
INSERT INTO `t_pca` VALUES ('431025', '临武县', null, '1');
INSERT INTO `t_pca` VALUES ('431026', '汝城县', null, '1');
INSERT INTO `t_pca` VALUES ('431027', '桂东县', null, '1');
INSERT INTO `t_pca` VALUES ('431028', '安仁县', null, '1');
INSERT INTO `t_pca` VALUES ('431081', '资兴市', null, '1');
INSERT INTO `t_pca` VALUES ('431100', '永州市', null, '1');
INSERT INTO `t_pca` VALUES ('431102', '零陵区', null, '1');
INSERT INTO `t_pca` VALUES ('431103', '冷水滩区', null, '1');
INSERT INTO `t_pca` VALUES ('431121', '祁阳县', null, '1');
INSERT INTO `t_pca` VALUES ('431122', '东安县', null, '1');
INSERT INTO `t_pca` VALUES ('431123', '双牌县', null, '1');
INSERT INTO `t_pca` VALUES ('431124', '道县', null, '1');
INSERT INTO `t_pca` VALUES ('431125', '江永县', null, '1');
INSERT INTO `t_pca` VALUES ('431126', '宁远县', null, '1');
INSERT INTO `t_pca` VALUES ('431127', '蓝山县', null, '1');
INSERT INTO `t_pca` VALUES ('431128', '新田县', null, '1');
INSERT INTO `t_pca` VALUES ('431129', '江华瑶族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('431200', '怀化市', null, '1');
INSERT INTO `t_pca` VALUES ('431202', '鹤城区', null, '1');
INSERT INTO `t_pca` VALUES ('431221', '中方县', null, '1');
INSERT INTO `t_pca` VALUES ('431222', '沅陵县', null, '1');
INSERT INTO `t_pca` VALUES ('431223', '辰溪县', null, '1');
INSERT INTO `t_pca` VALUES ('431224', '溆浦县', null, '1');
INSERT INTO `t_pca` VALUES ('431225', '会同县', null, '1');
INSERT INTO `t_pca` VALUES ('431226', '麻阳苗族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('431227', '新晃侗族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('431228', '芷江侗族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('431229', '靖州苗族侗族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('431230', '通道侗族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('431281', '洪江市', null, '1');
INSERT INTO `t_pca` VALUES ('431300', '娄底市', null, '1');
INSERT INTO `t_pca` VALUES ('431302', '娄星区', null, '1');
INSERT INTO `t_pca` VALUES ('431321', '双峰县', null, '1');
INSERT INTO `t_pca` VALUES ('431322', '新化县', null, '1');
INSERT INTO `t_pca` VALUES ('431381', '冷水江市', null, '1');
INSERT INTO `t_pca` VALUES ('431382', '涟源市', null, '1');
INSERT INTO `t_pca` VALUES ('433100', '湘西土家族苗族自治州', null, '1');
INSERT INTO `t_pca` VALUES ('433101', '吉首市', null, '1');
INSERT INTO `t_pca` VALUES ('433122', '泸溪县', null, '1');
INSERT INTO `t_pca` VALUES ('433123', '凤凰县', null, '1');
INSERT INTO `t_pca` VALUES ('433124', '花垣县', null, '1');
INSERT INTO `t_pca` VALUES ('433125', '保靖县', null, '1');
INSERT INTO `t_pca` VALUES ('433126', '古丈县', null, '1');
INSERT INTO `t_pca` VALUES ('433127', '永顺县', null, '1');
INSERT INTO `t_pca` VALUES ('433130', '龙山县', null, '1');
INSERT INTO `t_pca` VALUES ('440000', '广东省', null, '1');
INSERT INTO `t_pca` VALUES ('440100', '广州市', null, '1');
INSERT INTO `t_pca` VALUES ('440103', '荔湾区', null, '1');
INSERT INTO `t_pca` VALUES ('440104', '越秀区', null, '1');
INSERT INTO `t_pca` VALUES ('440105', '海珠区', null, '1');
INSERT INTO `t_pca` VALUES ('440106', '天河区', null, '1');
INSERT INTO `t_pca` VALUES ('440111', '白云区', null, '1');
INSERT INTO `t_pca` VALUES ('440112', '黄埔区', null, '1');
INSERT INTO `t_pca` VALUES ('440113', '番禺区', null, '1');
INSERT INTO `t_pca` VALUES ('440114', '花都区', null, '1');
INSERT INTO `t_pca` VALUES ('440115', '南沙区', null, '1');
INSERT INTO `t_pca` VALUES ('440117', '从化区', null, '1');
INSERT INTO `t_pca` VALUES ('440118', '增城区', null, '1');
INSERT INTO `t_pca` VALUES ('440200', '韶关市', null, '1');
INSERT INTO `t_pca` VALUES ('440203', '武江区', null, '1');
INSERT INTO `t_pca` VALUES ('440204', '浈江区', null, '1');
INSERT INTO `t_pca` VALUES ('440205', '曲江区', null, '1');
INSERT INTO `t_pca` VALUES ('440222', '始兴县', null, '1');
INSERT INTO `t_pca` VALUES ('440224', '仁化县', null, '1');
INSERT INTO `t_pca` VALUES ('440229', '翁源县', null, '1');
INSERT INTO `t_pca` VALUES ('440232', '乳源瑶族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('440233', '新丰县', null, '1');
INSERT INTO `t_pca` VALUES ('440281', '乐昌市', null, '1');
INSERT INTO `t_pca` VALUES ('440282', '南雄市', null, '1');
INSERT INTO `t_pca` VALUES ('440300', '深圳市', null, '1');
INSERT INTO `t_pca` VALUES ('440303', '罗湖区', null, '1');
INSERT INTO `t_pca` VALUES ('440304', '福田区', null, '1');
INSERT INTO `t_pca` VALUES ('440305', '南山区', null, '1');
INSERT INTO `t_pca` VALUES ('440306', '宝安区', null, '1');
INSERT INTO `t_pca` VALUES ('440307', '龙岗区', null, '1');
INSERT INTO `t_pca` VALUES ('440308', '盐田区', null, '1');
INSERT INTO `t_pca` VALUES ('440309', '龙华区', null, '1');
INSERT INTO `t_pca` VALUES ('440310', '坪山区', null, '1');
INSERT INTO `t_pca` VALUES ('440400', '珠海市', null, '1');
INSERT INTO `t_pca` VALUES ('440402', '香洲区', null, '1');
INSERT INTO `t_pca` VALUES ('440403', '斗门区', null, '1');
INSERT INTO `t_pca` VALUES ('440404', '金湾区', null, '1');
INSERT INTO `t_pca` VALUES ('440500', '汕头市', null, '1');
INSERT INTO `t_pca` VALUES ('440507', '龙湖区', null, '1');
INSERT INTO `t_pca` VALUES ('440511', '金平区', null, '1');
INSERT INTO `t_pca` VALUES ('440512', '濠江区', null, '1');
INSERT INTO `t_pca` VALUES ('440513', '潮阳区', null, '1');
INSERT INTO `t_pca` VALUES ('440514', '潮南区', null, '1');
INSERT INTO `t_pca` VALUES ('440515', '澄海区', null, '1');
INSERT INTO `t_pca` VALUES ('440523', '南澳县', null, '1');
INSERT INTO `t_pca` VALUES ('440600', '佛山市', null, '1');
INSERT INTO `t_pca` VALUES ('440604', '禅城区', null, '1');
INSERT INTO `t_pca` VALUES ('440605', '南海区', null, '1');
INSERT INTO `t_pca` VALUES ('440606', '顺德区', null, '1');
INSERT INTO `t_pca` VALUES ('440607', '三水区', null, '1');
INSERT INTO `t_pca` VALUES ('440608', '高明区', null, '1');
INSERT INTO `t_pca` VALUES ('440700', '江门市', null, '1');
INSERT INTO `t_pca` VALUES ('440703', '蓬江区', null, '1');
INSERT INTO `t_pca` VALUES ('440704', '江海区', null, '1');
INSERT INTO `t_pca` VALUES ('440705', '新会区', null, '1');
INSERT INTO `t_pca` VALUES ('440781', '台山市', null, '1');
INSERT INTO `t_pca` VALUES ('440783', '开平市', null, '1');
INSERT INTO `t_pca` VALUES ('440784', '鹤山市', null, '1');
INSERT INTO `t_pca` VALUES ('440785', '恩平市', null, '1');
INSERT INTO `t_pca` VALUES ('440800', '湛江市', null, '1');
INSERT INTO `t_pca` VALUES ('440802', '赤坎区', null, '1');
INSERT INTO `t_pca` VALUES ('440803', '霞山区', null, '1');
INSERT INTO `t_pca` VALUES ('440804', '坡头区', null, '1');
INSERT INTO `t_pca` VALUES ('440811', '麻章区', null, '1');
INSERT INTO `t_pca` VALUES ('440823', '遂溪县', null, '1');
INSERT INTO `t_pca` VALUES ('440825', '徐闻县', null, '1');
INSERT INTO `t_pca` VALUES ('440881', '廉江市', null, '1');
INSERT INTO `t_pca` VALUES ('440882', '雷州市', null, '1');
INSERT INTO `t_pca` VALUES ('440883', '吴川市', null, '1');
INSERT INTO `t_pca` VALUES ('440900', '茂名市', null, '1');
INSERT INTO `t_pca` VALUES ('440902', '茂南区', null, '1');
INSERT INTO `t_pca` VALUES ('440904', '电白区', null, '1');
INSERT INTO `t_pca` VALUES ('440981', '高州市', null, '1');
INSERT INTO `t_pca` VALUES ('440982', '化州市', null, '1');
INSERT INTO `t_pca` VALUES ('440983', '信宜市', null, '1');
INSERT INTO `t_pca` VALUES ('441200', '肇庆市', null, '1');
INSERT INTO `t_pca` VALUES ('441202', '端州区', null, '1');
INSERT INTO `t_pca` VALUES ('441203', '鼎湖区', null, '1');
INSERT INTO `t_pca` VALUES ('441204', '高要区', null, '1');
INSERT INTO `t_pca` VALUES ('441223', '广宁县', null, '1');
INSERT INTO `t_pca` VALUES ('441224', '怀集县', null, '1');
INSERT INTO `t_pca` VALUES ('441225', '封开县', null, '1');
INSERT INTO `t_pca` VALUES ('441226', '德庆县', null, '1');
INSERT INTO `t_pca` VALUES ('441284', '四会市', null, '1');
INSERT INTO `t_pca` VALUES ('441300', '惠州市', null, '1');
INSERT INTO `t_pca` VALUES ('441302', '惠城区', null, '1');
INSERT INTO `t_pca` VALUES ('441303', '惠阳区', null, '1');
INSERT INTO `t_pca` VALUES ('441322', '博罗县', null, '1');
INSERT INTO `t_pca` VALUES ('441323', '惠东县', null, '1');
INSERT INTO `t_pca` VALUES ('441324', '龙门县', null, '1');
INSERT INTO `t_pca` VALUES ('441400', '梅州市', null, '1');
INSERT INTO `t_pca` VALUES ('441402', '梅江区', null, '1');
INSERT INTO `t_pca` VALUES ('441403', '梅县区', null, '1');
INSERT INTO `t_pca` VALUES ('441422', '大埔县', null, '1');
INSERT INTO `t_pca` VALUES ('441423', '丰顺县', null, '1');
INSERT INTO `t_pca` VALUES ('441424', '五华县', null, '1');
INSERT INTO `t_pca` VALUES ('441426', '平远县', null, '1');
INSERT INTO `t_pca` VALUES ('441427', '蕉岭县', null, '1');
INSERT INTO `t_pca` VALUES ('441481', '兴宁市', null, '1');
INSERT INTO `t_pca` VALUES ('441500', '汕尾市', null, '1');
INSERT INTO `t_pca` VALUES ('441502', '城区', null, '1');
INSERT INTO `t_pca` VALUES ('441521', '海丰县', null, '1');
INSERT INTO `t_pca` VALUES ('441523', '陆河县', null, '1');
INSERT INTO `t_pca` VALUES ('441581', '陆丰市', null, '1');
INSERT INTO `t_pca` VALUES ('441600', '河源市', null, '1');
INSERT INTO `t_pca` VALUES ('441602', '源城区', null, '1');
INSERT INTO `t_pca` VALUES ('441621', '紫金县', null, '1');
INSERT INTO `t_pca` VALUES ('441622', '龙川县', null, '1');
INSERT INTO `t_pca` VALUES ('441623', '连平县', null, '1');
INSERT INTO `t_pca` VALUES ('441624', '和平县', null, '1');
INSERT INTO `t_pca` VALUES ('441625', '东源县', null, '1');
INSERT INTO `t_pca` VALUES ('441700', '阳江市', null, '1');
INSERT INTO `t_pca` VALUES ('441702', '江城区', null, '1');
INSERT INTO `t_pca` VALUES ('441704', '阳东区', null, '1');
INSERT INTO `t_pca` VALUES ('441721', '阳西县', null, '1');
INSERT INTO `t_pca` VALUES ('441781', '阳春市', null, '1');
INSERT INTO `t_pca` VALUES ('441800', '清远市', null, '1');
INSERT INTO `t_pca` VALUES ('441802', '清城区', null, '1');
INSERT INTO `t_pca` VALUES ('441803', '清新区', null, '1');
INSERT INTO `t_pca` VALUES ('441821', '佛冈县', null, '1');
INSERT INTO `t_pca` VALUES ('441823', '阳山县', null, '1');
INSERT INTO `t_pca` VALUES ('441825', '连山壮族瑶族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('441826', '连南瑶族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('441881', '英德市', null, '1');
INSERT INTO `t_pca` VALUES ('441882', '连州市', null, '1');
INSERT INTO `t_pca` VALUES ('441900', '东莞市', null, '1');
INSERT INTO `t_pca` VALUES ('442000', '中山市', null, '1');
INSERT INTO `t_pca` VALUES ('445100', '潮州市', null, '1');
INSERT INTO `t_pca` VALUES ('445102', '湘桥区', null, '1');
INSERT INTO `t_pca` VALUES ('445103', '潮安区', null, '1');
INSERT INTO `t_pca` VALUES ('445122', '饶平县', null, '1');
INSERT INTO `t_pca` VALUES ('445200', '揭阳市', null, '1');
INSERT INTO `t_pca` VALUES ('445202', '榕城区', null, '1');
INSERT INTO `t_pca` VALUES ('445203', '揭东区', null, '1');
INSERT INTO `t_pca` VALUES ('445222', '揭西县', null, '1');
INSERT INTO `t_pca` VALUES ('445224', '惠来县', null, '1');
INSERT INTO `t_pca` VALUES ('445281', '普宁市', null, '1');
INSERT INTO `t_pca` VALUES ('445300', '云浮市', null, '1');
INSERT INTO `t_pca` VALUES ('445302', '云城区', null, '1');
INSERT INTO `t_pca` VALUES ('445303', '云安区', null, '1');
INSERT INTO `t_pca` VALUES ('445321', '新兴县', null, '1');
INSERT INTO `t_pca` VALUES ('445322', '郁南县', null, '1');
INSERT INTO `t_pca` VALUES ('445381', '罗定市', null, '1');
INSERT INTO `t_pca` VALUES ('450000', '广西壮族自治区', null, '1');
INSERT INTO `t_pca` VALUES ('450100', '南宁市', null, '1');
INSERT INTO `t_pca` VALUES ('450102', '兴宁区', null, '1');
INSERT INTO `t_pca` VALUES ('450103', '青秀区', null, '1');
INSERT INTO `t_pca` VALUES ('450105', '江南区', null, '1');
INSERT INTO `t_pca` VALUES ('450107', '西乡塘区', null, '1');
INSERT INTO `t_pca` VALUES ('450108', '良庆区', null, '1');
INSERT INTO `t_pca` VALUES ('450109', '邕宁区', null, '1');
INSERT INTO `t_pca` VALUES ('450110', '武鸣区', null, '1');
INSERT INTO `t_pca` VALUES ('450123', '隆安县', null, '1');
INSERT INTO `t_pca` VALUES ('450124', '马山县', null, '1');
INSERT INTO `t_pca` VALUES ('450125', '上林县', null, '1');
INSERT INTO `t_pca` VALUES ('450126', '宾阳县', null, '1');
INSERT INTO `t_pca` VALUES ('450127', '横县', null, '1');
INSERT INTO `t_pca` VALUES ('450200', '柳州市', null, '1');
INSERT INTO `t_pca` VALUES ('450202', '城中区', null, '1');
INSERT INTO `t_pca` VALUES ('450203', '鱼峰区', null, '1');
INSERT INTO `t_pca` VALUES ('450204', '柳南区', null, '1');
INSERT INTO `t_pca` VALUES ('450205', '柳北区', null, '1');
INSERT INTO `t_pca` VALUES ('450206', '柳江区', null, '1');
INSERT INTO `t_pca` VALUES ('450222', '柳城县', null, '1');
INSERT INTO `t_pca` VALUES ('450223', '鹿寨县', null, '1');
INSERT INTO `t_pca` VALUES ('450224', '融安县', null, '1');
INSERT INTO `t_pca` VALUES ('450225', '融水苗族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('450226', '三江侗族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('450300', '桂林市', null, '1');
INSERT INTO `t_pca` VALUES ('450302', '秀峰区', null, '1');
INSERT INTO `t_pca` VALUES ('450303', '叠彩区', null, '1');
INSERT INTO `t_pca` VALUES ('450304', '象山区', null, '1');
INSERT INTO `t_pca` VALUES ('450305', '七星区', null, '1');
INSERT INTO `t_pca` VALUES ('450311', '雁山区', null, '1');
INSERT INTO `t_pca` VALUES ('450312', '临桂区', null, '1');
INSERT INTO `t_pca` VALUES ('450321', '阳朔县', null, '1');
INSERT INTO `t_pca` VALUES ('450323', '灵川县', null, '1');
INSERT INTO `t_pca` VALUES ('450324', '全州县', null, '1');
INSERT INTO `t_pca` VALUES ('450325', '兴安县', null, '1');
INSERT INTO `t_pca` VALUES ('450326', '永福县', null, '1');
INSERT INTO `t_pca` VALUES ('450327', '灌阳县', null, '1');
INSERT INTO `t_pca` VALUES ('450328', '龙胜各族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('450329', '资源县', null, '1');
INSERT INTO `t_pca` VALUES ('450330', '平乐县', null, '1');
INSERT INTO `t_pca` VALUES ('450331', '荔浦县', null, '1');
INSERT INTO `t_pca` VALUES ('450332', '恭城瑶族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('450400', '梧州市', null, '1');
INSERT INTO `t_pca` VALUES ('450403', '万秀区', null, '1');
INSERT INTO `t_pca` VALUES ('450405', '长洲区', null, '1');
INSERT INTO `t_pca` VALUES ('450406', '龙圩区', null, '1');
INSERT INTO `t_pca` VALUES ('450421', '苍梧县', null, '1');
INSERT INTO `t_pca` VALUES ('450422', '藤县', null, '1');
INSERT INTO `t_pca` VALUES ('450423', '蒙山县', null, '1');
INSERT INTO `t_pca` VALUES ('450481', '岑溪市', null, '1');
INSERT INTO `t_pca` VALUES ('450500', '北海市', null, '1');
INSERT INTO `t_pca` VALUES ('450502', '海城区', null, '1');
INSERT INTO `t_pca` VALUES ('450503', '银海区', null, '1');
INSERT INTO `t_pca` VALUES ('450512', '铁山港区', null, '1');
INSERT INTO `t_pca` VALUES ('450521', '合浦县', null, '1');
INSERT INTO `t_pca` VALUES ('450600', '防城港市', null, '1');
INSERT INTO `t_pca` VALUES ('450602', '港口区', null, '1');
INSERT INTO `t_pca` VALUES ('450603', '防城区', null, '1');
INSERT INTO `t_pca` VALUES ('450621', '上思县', null, '1');
INSERT INTO `t_pca` VALUES ('450681', '东兴市', null, '1');
INSERT INTO `t_pca` VALUES ('450700', '钦州市', null, '1');
INSERT INTO `t_pca` VALUES ('450702', '钦南区', null, '1');
INSERT INTO `t_pca` VALUES ('450703', '钦北区', null, '1');
INSERT INTO `t_pca` VALUES ('450721', '灵山县', null, '1');
INSERT INTO `t_pca` VALUES ('450722', '浦北县', null, '1');
INSERT INTO `t_pca` VALUES ('450800', '贵港市', null, '1');
INSERT INTO `t_pca` VALUES ('450802', '港北区', null, '1');
INSERT INTO `t_pca` VALUES ('450803', '港南区', null, '1');
INSERT INTO `t_pca` VALUES ('450804', '覃塘区', null, '1');
INSERT INTO `t_pca` VALUES ('450821', '平南县', null, '1');
INSERT INTO `t_pca` VALUES ('450881', '桂平市', null, '1');
INSERT INTO `t_pca` VALUES ('450900', '玉林市', null, '1');
INSERT INTO `t_pca` VALUES ('450902', '玉州区', null, '1');
INSERT INTO `t_pca` VALUES ('450903', '福绵区', null, '1');
INSERT INTO `t_pca` VALUES ('450921', '容县', null, '1');
INSERT INTO `t_pca` VALUES ('450922', '陆川县', null, '1');
INSERT INTO `t_pca` VALUES ('450923', '博白县', null, '1');
INSERT INTO `t_pca` VALUES ('450924', '兴业县', null, '1');
INSERT INTO `t_pca` VALUES ('450981', '北流市', null, '1');
INSERT INTO `t_pca` VALUES ('451000', '百色市', null, '1');
INSERT INTO `t_pca` VALUES ('451002', '右江区', null, '1');
INSERT INTO `t_pca` VALUES ('451021', '田阳县', null, '1');
INSERT INTO `t_pca` VALUES ('451022', '田东县', null, '1');
INSERT INTO `t_pca` VALUES ('451023', '平果县', null, '1');
INSERT INTO `t_pca` VALUES ('451024', '德保县', null, '1');
INSERT INTO `t_pca` VALUES ('451026', '那坡县', null, '1');
INSERT INTO `t_pca` VALUES ('451027', '凌云县', null, '1');
INSERT INTO `t_pca` VALUES ('451028', '乐业县', null, '1');
INSERT INTO `t_pca` VALUES ('451029', '田林县', null, '1');
INSERT INTO `t_pca` VALUES ('451030', '西林县', null, '1');
INSERT INTO `t_pca` VALUES ('451031', '隆林各族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('451081', '靖西市', null, '1');
INSERT INTO `t_pca` VALUES ('451100', '贺州市', null, '1');
INSERT INTO `t_pca` VALUES ('451102', '八步区', null, '1');
INSERT INTO `t_pca` VALUES ('451103', '平桂区', null, '1');
INSERT INTO `t_pca` VALUES ('451121', '昭平县', null, '1');
INSERT INTO `t_pca` VALUES ('451122', '钟山县', null, '1');
INSERT INTO `t_pca` VALUES ('451123', '富川瑶族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('451200', '河池市', null, '1');
INSERT INTO `t_pca` VALUES ('451202', '金城江区', null, '1');
INSERT INTO `t_pca` VALUES ('451203', '宜州区', null, '1');
INSERT INTO `t_pca` VALUES ('451221', '南丹县', null, '1');
INSERT INTO `t_pca` VALUES ('451222', '天峨县', null, '1');
INSERT INTO `t_pca` VALUES ('451223', '凤山县', null, '1');
INSERT INTO `t_pca` VALUES ('451224', '东兰县', null, '1');
INSERT INTO `t_pca` VALUES ('451225', '罗城仫佬族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('451226', '环江毛南族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('451227', '巴马瑶族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('451228', '都安瑶族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('451229', '大化瑶族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('451300', '来宾市', null, '1');
INSERT INTO `t_pca` VALUES ('451302', '兴宾区', null, '1');
INSERT INTO `t_pca` VALUES ('451321', '忻城县', null, '1');
INSERT INTO `t_pca` VALUES ('451322', '象州县', null, '1');
INSERT INTO `t_pca` VALUES ('451323', '武宣县', null, '1');
INSERT INTO `t_pca` VALUES ('451324', '金秀瑶族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('451381', '合山市', null, '1');
INSERT INTO `t_pca` VALUES ('451400', '崇左市', null, '1');
INSERT INTO `t_pca` VALUES ('451402', '江州区', null, '1');
INSERT INTO `t_pca` VALUES ('451421', '扶绥县', null, '1');
INSERT INTO `t_pca` VALUES ('451422', '宁明县', null, '1');
INSERT INTO `t_pca` VALUES ('451423', '龙州县', null, '1');
INSERT INTO `t_pca` VALUES ('451424', '大新县', null, '1');
INSERT INTO `t_pca` VALUES ('451425', '天等县', null, '1');
INSERT INTO `t_pca` VALUES ('451481', '凭祥市', null, '1');
INSERT INTO `t_pca` VALUES ('460000', '海南省', null, '1');
INSERT INTO `t_pca` VALUES ('460100', '海口市', null, '1');
INSERT INTO `t_pca` VALUES ('460105', '秀英区', null, '1');
INSERT INTO `t_pca` VALUES ('460106', '龙华区', null, '1');
INSERT INTO `t_pca` VALUES ('460107', '琼山区', null, '1');
INSERT INTO `t_pca` VALUES ('460108', '美兰区', null, '1');
INSERT INTO `t_pca` VALUES ('460200', '三亚市', null, '1');
INSERT INTO `t_pca` VALUES ('460202', '海棠区', null, '1');
INSERT INTO `t_pca` VALUES ('460203', '吉阳区', null, '1');
INSERT INTO `t_pca` VALUES ('460204', '天涯区', null, '1');
INSERT INTO `t_pca` VALUES ('460205', '崖州区', null, '1');
INSERT INTO `t_pca` VALUES ('460300', '三沙市', null, '1');
INSERT INTO `t_pca` VALUES ('460400', '儋州市', null, '1');
INSERT INTO `t_pca` VALUES ('469001', '五指山市', null, '1');
INSERT INTO `t_pca` VALUES ('469002', '琼海市', null, '1');
INSERT INTO `t_pca` VALUES ('469005', '文昌市', null, '1');
INSERT INTO `t_pca` VALUES ('469006', '万宁市', null, '1');
INSERT INTO `t_pca` VALUES ('469007', '东方市', null, '1');
INSERT INTO `t_pca` VALUES ('469021', '定安县', null, '1');
INSERT INTO `t_pca` VALUES ('469022', '屯昌县', null, '1');
INSERT INTO `t_pca` VALUES ('469023', '澄迈县', null, '1');
INSERT INTO `t_pca` VALUES ('469024', '临高县', null, '1');
INSERT INTO `t_pca` VALUES ('469025', '白沙黎族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('469026', '昌江黎族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('469027', '乐东黎族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('469028', '陵水黎族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('469029', '保亭黎族苗族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('469030', '琼中黎族苗族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('500000', '重庆市', null, '1');
INSERT INTO `t_pca` VALUES ('500101', '万州区', null, '1');
INSERT INTO `t_pca` VALUES ('500102', '涪陵区', null, '1');
INSERT INTO `t_pca` VALUES ('500103', '渝中区', null, '1');
INSERT INTO `t_pca` VALUES ('500104', '大渡口区', null, '1');
INSERT INTO `t_pca` VALUES ('500105', '江北区', null, '1');
INSERT INTO `t_pca` VALUES ('500106', '沙坪坝区', null, '1');
INSERT INTO `t_pca` VALUES ('500107', '九龙坡区', null, '1');
INSERT INTO `t_pca` VALUES ('500108', '南岸区', null, '1');
INSERT INTO `t_pca` VALUES ('500109', '北碚区', null, '1');
INSERT INTO `t_pca` VALUES ('500110', '綦江区', null, '1');
INSERT INTO `t_pca` VALUES ('500111', '大足区', null, '1');
INSERT INTO `t_pca` VALUES ('500112', '渝北区', null, '1');
INSERT INTO `t_pca` VALUES ('500113', '巴南区', null, '1');
INSERT INTO `t_pca` VALUES ('500114', '黔江区', null, '1');
INSERT INTO `t_pca` VALUES ('500115', '长寿区', null, '1');
INSERT INTO `t_pca` VALUES ('500116', '江津区', null, '1');
INSERT INTO `t_pca` VALUES ('500117', '合川区', null, '1');
INSERT INTO `t_pca` VALUES ('500118', '永川区', null, '1');
INSERT INTO `t_pca` VALUES ('500119', '南川区', null, '1');
INSERT INTO `t_pca` VALUES ('500120', '璧山区', null, '1');
INSERT INTO `t_pca` VALUES ('500151', '铜梁区', null, '1');
INSERT INTO `t_pca` VALUES ('500152', '潼南区', null, '1');
INSERT INTO `t_pca` VALUES ('500153', '荣昌区', null, '1');
INSERT INTO `t_pca` VALUES ('500154', '开州区', null, '1');
INSERT INTO `t_pca` VALUES ('500155', '梁平区', null, '1');
INSERT INTO `t_pca` VALUES ('500156', '武隆区', null, '1');
INSERT INTO `t_pca` VALUES ('500229', '城口县', null, '1');
INSERT INTO `t_pca` VALUES ('500230', '丰都县', null, '1');
INSERT INTO `t_pca` VALUES ('500231', '垫江县', null, '1');
INSERT INTO `t_pca` VALUES ('500233', '忠县', null, '1');
INSERT INTO `t_pca` VALUES ('500235', '云阳县', null, '1');
INSERT INTO `t_pca` VALUES ('500236', '奉节县', null, '1');
INSERT INTO `t_pca` VALUES ('500237', '巫山县', null, '1');
INSERT INTO `t_pca` VALUES ('500238', '巫溪县', null, '1');
INSERT INTO `t_pca` VALUES ('500240', '石柱土家族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('500241', '秀山土家族苗族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('500242', '酉阳土家族苗族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('500243', '彭水苗族土家族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('510000', '四川省', null, '1');
INSERT INTO `t_pca` VALUES ('510100', '成都市', null, '1');
INSERT INTO `t_pca` VALUES ('510104', '锦江区', null, '1');
INSERT INTO `t_pca` VALUES ('510105', '青羊区', null, '1');
INSERT INTO `t_pca` VALUES ('510106', '金牛区', null, '1');
INSERT INTO `t_pca` VALUES ('510107', '武侯区', null, '1');
INSERT INTO `t_pca` VALUES ('510108', '成华区', null, '1');
INSERT INTO `t_pca` VALUES ('510112', '龙泉驿区', null, '1');
INSERT INTO `t_pca` VALUES ('510113', '青白江区', null, '1');
INSERT INTO `t_pca` VALUES ('510114', '新都区', null, '1');
INSERT INTO `t_pca` VALUES ('510115', '温江区', null, '1');
INSERT INTO `t_pca` VALUES ('510116', '双流区', null, '1');
INSERT INTO `t_pca` VALUES ('510117', '郫都区', null, '1');
INSERT INTO `t_pca` VALUES ('510121', '金堂县', null, '1');
INSERT INTO `t_pca` VALUES ('510129', '大邑县', null, '1');
INSERT INTO `t_pca` VALUES ('510131', '蒲江县', null, '1');
INSERT INTO `t_pca` VALUES ('510132', '新津县', null, '1');
INSERT INTO `t_pca` VALUES ('510181', '都江堰市', null, '1');
INSERT INTO `t_pca` VALUES ('510182', '彭州市', null, '1');
INSERT INTO `t_pca` VALUES ('510183', '邛崃市', null, '1');
INSERT INTO `t_pca` VALUES ('510184', '崇州市', null, '1');
INSERT INTO `t_pca` VALUES ('510185', '简阳市', null, '1');
INSERT INTO `t_pca` VALUES ('510300', '自贡市', null, '1');
INSERT INTO `t_pca` VALUES ('510302', '自流井区', null, '1');
INSERT INTO `t_pca` VALUES ('510303', '贡井区', null, '1');
INSERT INTO `t_pca` VALUES ('510304', '大安区', null, '1');
INSERT INTO `t_pca` VALUES ('510311', '沿滩区', null, '1');
INSERT INTO `t_pca` VALUES ('510321', '荣县', null, '1');
INSERT INTO `t_pca` VALUES ('510322', '富顺县', null, '1');
INSERT INTO `t_pca` VALUES ('510400', '攀枝花市', null, '1');
INSERT INTO `t_pca` VALUES ('510402', '东区', null, '1');
INSERT INTO `t_pca` VALUES ('510403', '西区', null, '1');
INSERT INTO `t_pca` VALUES ('510411', '仁和区', null, '1');
INSERT INTO `t_pca` VALUES ('510421', '米易县', null, '1');
INSERT INTO `t_pca` VALUES ('510422', '盐边县', null, '1');
INSERT INTO `t_pca` VALUES ('510500', '泸州市', null, '1');
INSERT INTO `t_pca` VALUES ('510502', '江阳区', null, '1');
INSERT INTO `t_pca` VALUES ('510503', '纳溪区', null, '1');
INSERT INTO `t_pca` VALUES ('510504', '龙马潭区', null, '1');
INSERT INTO `t_pca` VALUES ('510521', '泸县', null, '1');
INSERT INTO `t_pca` VALUES ('510522', '合江县', null, '1');
INSERT INTO `t_pca` VALUES ('510524', '叙永县', null, '1');
INSERT INTO `t_pca` VALUES ('510525', '古蔺县', null, '1');
INSERT INTO `t_pca` VALUES ('510600', '德阳市', null, '1');
INSERT INTO `t_pca` VALUES ('510603', '旌阳区', null, '1');
INSERT INTO `t_pca` VALUES ('510604', '罗江区', null, '1');
INSERT INTO `t_pca` VALUES ('510623', '中江县', null, '1');
INSERT INTO `t_pca` VALUES ('510681', '广汉市', null, '1');
INSERT INTO `t_pca` VALUES ('510682', '什邡市', null, '1');
INSERT INTO `t_pca` VALUES ('510683', '绵竹市', null, '1');
INSERT INTO `t_pca` VALUES ('510700', '绵阳市', null, '1');
INSERT INTO `t_pca` VALUES ('510703', '涪城区', null, '1');
INSERT INTO `t_pca` VALUES ('510704', '游仙区', null, '1');
INSERT INTO `t_pca` VALUES ('510705', '安州区', null, '1');
INSERT INTO `t_pca` VALUES ('510722', '三台县', null, '1');
INSERT INTO `t_pca` VALUES ('510723', '盐亭县', null, '1');
INSERT INTO `t_pca` VALUES ('510725', '梓潼县', null, '1');
INSERT INTO `t_pca` VALUES ('510726', '北川羌族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('510727', '平武县', null, '1');
INSERT INTO `t_pca` VALUES ('510781', '江油市', null, '1');
INSERT INTO `t_pca` VALUES ('510800', '广元市', null, '1');
INSERT INTO `t_pca` VALUES ('510802', '利州区', null, '1');
INSERT INTO `t_pca` VALUES ('510811', '昭化区', null, '1');
INSERT INTO `t_pca` VALUES ('510812', '朝天区', null, '1');
INSERT INTO `t_pca` VALUES ('510821', '旺苍县', null, '1');
INSERT INTO `t_pca` VALUES ('510822', '青川县', null, '1');
INSERT INTO `t_pca` VALUES ('510823', '剑阁县', null, '1');
INSERT INTO `t_pca` VALUES ('510824', '苍溪县', null, '1');
INSERT INTO `t_pca` VALUES ('510900', '遂宁市', null, '1');
INSERT INTO `t_pca` VALUES ('510903', '船山区', null, '1');
INSERT INTO `t_pca` VALUES ('510904', '安居区', null, '1');
INSERT INTO `t_pca` VALUES ('510921', '蓬溪县', null, '1');
INSERT INTO `t_pca` VALUES ('510922', '射洪县', null, '1');
INSERT INTO `t_pca` VALUES ('510923', '大英县', null, '1');
INSERT INTO `t_pca` VALUES ('511000', '内江市', null, '1');
INSERT INTO `t_pca` VALUES ('511002', '市中区', null, '1');
INSERT INTO `t_pca` VALUES ('511011', '东兴区', null, '1');
INSERT INTO `t_pca` VALUES ('511024', '威远县', null, '1');
INSERT INTO `t_pca` VALUES ('511025', '资中县', null, '1');
INSERT INTO `t_pca` VALUES ('511083', '隆昌市', null, '1');
INSERT INTO `t_pca` VALUES ('511100', '乐山市', null, '1');
INSERT INTO `t_pca` VALUES ('511102', '市中区', null, '1');
INSERT INTO `t_pca` VALUES ('511111', '沙湾区', null, '1');
INSERT INTO `t_pca` VALUES ('511112', '五通桥区', null, '1');
INSERT INTO `t_pca` VALUES ('511113', '金口河区', null, '1');
INSERT INTO `t_pca` VALUES ('511123', '犍为县', null, '1');
INSERT INTO `t_pca` VALUES ('511124', '井研县', null, '1');
INSERT INTO `t_pca` VALUES ('511126', '夹江县', null, '1');
INSERT INTO `t_pca` VALUES ('511129', '沐川县', null, '1');
INSERT INTO `t_pca` VALUES ('511132', '峨边彝族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('511133', '马边彝族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('511181', '峨眉山市', null, '1');
INSERT INTO `t_pca` VALUES ('511300', '南充市', null, '1');
INSERT INTO `t_pca` VALUES ('511302', '顺庆区', null, '1');
INSERT INTO `t_pca` VALUES ('511303', '高坪区', null, '1');
INSERT INTO `t_pca` VALUES ('511304', '嘉陵区', null, '1');
INSERT INTO `t_pca` VALUES ('511321', '南部县', null, '1');
INSERT INTO `t_pca` VALUES ('511322', '营山县', null, '1');
INSERT INTO `t_pca` VALUES ('511323', '蓬安县', null, '1');
INSERT INTO `t_pca` VALUES ('511324', '仪陇县', null, '1');
INSERT INTO `t_pca` VALUES ('511325', '西充县', null, '1');
INSERT INTO `t_pca` VALUES ('511381', '阆中市', null, '1');
INSERT INTO `t_pca` VALUES ('511400', '眉山市', null, '1');
INSERT INTO `t_pca` VALUES ('511402', '东坡区', null, '1');
INSERT INTO `t_pca` VALUES ('511403', '彭山区', null, '1');
INSERT INTO `t_pca` VALUES ('511421', '仁寿县', null, '1');
INSERT INTO `t_pca` VALUES ('511423', '洪雅县', null, '1');
INSERT INTO `t_pca` VALUES ('511424', '丹棱县', null, '1');
INSERT INTO `t_pca` VALUES ('511425', '青神县', null, '1');
INSERT INTO `t_pca` VALUES ('511500', '宜宾市', null, '1');
INSERT INTO `t_pca` VALUES ('511502', '翠屏区', null, '1');
INSERT INTO `t_pca` VALUES ('511503', '南溪区', null, '1');
INSERT INTO `t_pca` VALUES ('511521', '宜宾县', null, '1');
INSERT INTO `t_pca` VALUES ('511523', '江安县', null, '1');
INSERT INTO `t_pca` VALUES ('511524', '长宁县', null, '1');
INSERT INTO `t_pca` VALUES ('511525', '高县', null, '1');
INSERT INTO `t_pca` VALUES ('511526', '珙县', null, '1');
INSERT INTO `t_pca` VALUES ('511527', '筠连县', null, '1');
INSERT INTO `t_pca` VALUES ('511528', '兴文县', null, '1');
INSERT INTO `t_pca` VALUES ('511529', '屏山县', null, '1');
INSERT INTO `t_pca` VALUES ('511600', '广安市', null, '1');
INSERT INTO `t_pca` VALUES ('511602', '广安区', null, '1');
INSERT INTO `t_pca` VALUES ('511603', '前锋区', null, '1');
INSERT INTO `t_pca` VALUES ('511621', '岳池县', null, '1');
INSERT INTO `t_pca` VALUES ('511622', '武胜县', null, '1');
INSERT INTO `t_pca` VALUES ('511623', '邻水县', null, '1');
INSERT INTO `t_pca` VALUES ('511681', '华蓥市', null, '1');
INSERT INTO `t_pca` VALUES ('511700', '达州市', null, '1');
INSERT INTO `t_pca` VALUES ('511702', '通川区', null, '1');
INSERT INTO `t_pca` VALUES ('511703', '达川区', null, '1');
INSERT INTO `t_pca` VALUES ('511722', '宣汉县', null, '1');
INSERT INTO `t_pca` VALUES ('511723', '开江县', null, '1');
INSERT INTO `t_pca` VALUES ('511724', '大竹县', null, '1');
INSERT INTO `t_pca` VALUES ('511725', '渠县', null, '1');
INSERT INTO `t_pca` VALUES ('511781', '万源市', null, '1');
INSERT INTO `t_pca` VALUES ('511800', '雅安市', null, '1');
INSERT INTO `t_pca` VALUES ('511802', '雨城区', null, '1');
INSERT INTO `t_pca` VALUES ('511803', '名山区', null, '1');
INSERT INTO `t_pca` VALUES ('511822', '荥经县', null, '1');
INSERT INTO `t_pca` VALUES ('511823', '汉源县', null, '1');
INSERT INTO `t_pca` VALUES ('511824', '石棉县', null, '1');
INSERT INTO `t_pca` VALUES ('511825', '天全县', null, '1');
INSERT INTO `t_pca` VALUES ('511826', '芦山县', null, '1');
INSERT INTO `t_pca` VALUES ('511827', '宝兴县', null, '1');
INSERT INTO `t_pca` VALUES ('511900', '巴中市', null, '1');
INSERT INTO `t_pca` VALUES ('511902', '巴州区', null, '1');
INSERT INTO `t_pca` VALUES ('511903', '恩阳区', null, '1');
INSERT INTO `t_pca` VALUES ('511921', '通江县', null, '1');
INSERT INTO `t_pca` VALUES ('511922', '南江县', null, '1');
INSERT INTO `t_pca` VALUES ('511923', '平昌县', null, '1');
INSERT INTO `t_pca` VALUES ('512000', '资阳市', null, '1');
INSERT INTO `t_pca` VALUES ('512002', '雁江区', null, '1');
INSERT INTO `t_pca` VALUES ('512021', '安岳县', null, '1');
INSERT INTO `t_pca` VALUES ('512022', '乐至县', null, '1');
INSERT INTO `t_pca` VALUES ('513200', '阿坝藏族羌族自治州', null, '1');
INSERT INTO `t_pca` VALUES ('513201', '马尔康市', null, '1');
INSERT INTO `t_pca` VALUES ('513221', '汶川县', null, '1');
INSERT INTO `t_pca` VALUES ('513222', '理县', null, '1');
INSERT INTO `t_pca` VALUES ('513223', '茂县', null, '1');
INSERT INTO `t_pca` VALUES ('513224', '松潘县', null, '1');
INSERT INTO `t_pca` VALUES ('513225', '九寨沟县', null, '1');
INSERT INTO `t_pca` VALUES ('513226', '金川县', null, '1');
INSERT INTO `t_pca` VALUES ('513227', '小金县', null, '1');
INSERT INTO `t_pca` VALUES ('513228', '黑水县', null, '1');
INSERT INTO `t_pca` VALUES ('513230', '壤塘县', null, '1');
INSERT INTO `t_pca` VALUES ('513231', '阿坝县', null, '1');
INSERT INTO `t_pca` VALUES ('513232', '若尔盖县', null, '1');
INSERT INTO `t_pca` VALUES ('513233', '红原县', null, '1');
INSERT INTO `t_pca` VALUES ('513300', '甘孜藏族自治州', null, '1');
INSERT INTO `t_pca` VALUES ('513301', '康定市', null, '1');
INSERT INTO `t_pca` VALUES ('513322', '泸定县', null, '1');
INSERT INTO `t_pca` VALUES ('513323', '丹巴县', null, '1');
INSERT INTO `t_pca` VALUES ('513324', '九龙县', null, '1');
INSERT INTO `t_pca` VALUES ('513325', '雅江县', null, '1');
INSERT INTO `t_pca` VALUES ('513326', '道孚县', null, '1');
INSERT INTO `t_pca` VALUES ('513327', '炉霍县', null, '1');
INSERT INTO `t_pca` VALUES ('513328', '甘孜县', null, '1');
INSERT INTO `t_pca` VALUES ('513329', '新龙县', null, '1');
INSERT INTO `t_pca` VALUES ('513330', '德格县', null, '1');
INSERT INTO `t_pca` VALUES ('513331', '白玉县', null, '1');
INSERT INTO `t_pca` VALUES ('513332', '石渠县', null, '1');
INSERT INTO `t_pca` VALUES ('513333', '色达县', null, '1');
INSERT INTO `t_pca` VALUES ('513334', '理塘县', null, '1');
INSERT INTO `t_pca` VALUES ('513335', '巴塘县', null, '1');
INSERT INTO `t_pca` VALUES ('513336', '乡城县', null, '1');
INSERT INTO `t_pca` VALUES ('513337', '稻城县', null, '1');
INSERT INTO `t_pca` VALUES ('513338', '得荣县', null, '1');
INSERT INTO `t_pca` VALUES ('513400', '凉山彝族自治州', null, '1');
INSERT INTO `t_pca` VALUES ('513401', '西昌市', null, '1');
INSERT INTO `t_pca` VALUES ('513422', '木里藏族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('513423', '盐源县', null, '1');
INSERT INTO `t_pca` VALUES ('513424', '德昌县', null, '1');
INSERT INTO `t_pca` VALUES ('513425', '会理县', null, '1');
INSERT INTO `t_pca` VALUES ('513426', '会东县', null, '1');
INSERT INTO `t_pca` VALUES ('513427', '宁南县', null, '1');
INSERT INTO `t_pca` VALUES ('513428', '普格县', null, '1');
INSERT INTO `t_pca` VALUES ('513429', '布拖县', null, '1');
INSERT INTO `t_pca` VALUES ('513430', '金阳县', null, '1');
INSERT INTO `t_pca` VALUES ('513431', '昭觉县', null, '1');
INSERT INTO `t_pca` VALUES ('513432', '喜德县', null, '1');
INSERT INTO `t_pca` VALUES ('513433', '冕宁县', null, '1');
INSERT INTO `t_pca` VALUES ('513434', '越西县', null, '1');
INSERT INTO `t_pca` VALUES ('513435', '甘洛县', null, '1');
INSERT INTO `t_pca` VALUES ('513436', '美姑县', null, '1');
INSERT INTO `t_pca` VALUES ('513437', '雷波县', null, '1');
INSERT INTO `t_pca` VALUES ('520000', '贵州省', null, '1');
INSERT INTO `t_pca` VALUES ('520100', '贵阳市', null, '1');
INSERT INTO `t_pca` VALUES ('520102', '南明区', null, '1');
INSERT INTO `t_pca` VALUES ('520103', '云岩区', null, '1');
INSERT INTO `t_pca` VALUES ('520111', '花溪区', null, '1');
INSERT INTO `t_pca` VALUES ('520112', '乌当区', null, '1');
INSERT INTO `t_pca` VALUES ('520113', '白云区', null, '1');
INSERT INTO `t_pca` VALUES ('520115', '观山湖区', null, '1');
INSERT INTO `t_pca` VALUES ('520121', '开阳县', null, '1');
INSERT INTO `t_pca` VALUES ('520122', '息烽县', null, '1');
INSERT INTO `t_pca` VALUES ('520123', '修文县', null, '1');
INSERT INTO `t_pca` VALUES ('520181', '清镇市', null, '1');
INSERT INTO `t_pca` VALUES ('520200', '六盘水市', null, '1');
INSERT INTO `t_pca` VALUES ('520201', '钟山区', null, '1');
INSERT INTO `t_pca` VALUES ('520203', '六枝特区', null, '1');
INSERT INTO `t_pca` VALUES ('520221', '水城县', null, '1');
INSERT INTO `t_pca` VALUES ('520281', '盘州市', null, '1');
INSERT INTO `t_pca` VALUES ('520300', '遵义市', null, '1');
INSERT INTO `t_pca` VALUES ('520302', '红花岗区', null, '1');
INSERT INTO `t_pca` VALUES ('520303', '汇川区', null, '1');
INSERT INTO `t_pca` VALUES ('520304', '播州区', null, '1');
INSERT INTO `t_pca` VALUES ('520322', '桐梓县', null, '1');
INSERT INTO `t_pca` VALUES ('520323', '绥阳县', null, '1');
INSERT INTO `t_pca` VALUES ('520324', '正安县', null, '1');
INSERT INTO `t_pca` VALUES ('520325', '道真仡佬族苗族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('520326', '务川仡佬族苗族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('520327', '凤冈县', null, '1');
INSERT INTO `t_pca` VALUES ('520328', '湄潭县', null, '1');
INSERT INTO `t_pca` VALUES ('520329', '余庆县', null, '1');
INSERT INTO `t_pca` VALUES ('520330', '习水县', null, '1');
INSERT INTO `t_pca` VALUES ('520381', '赤水市', null, '1');
INSERT INTO `t_pca` VALUES ('520382', '仁怀市', null, '1');
INSERT INTO `t_pca` VALUES ('520400', '安顺市', null, '1');
INSERT INTO `t_pca` VALUES ('520402', '西秀区', null, '1');
INSERT INTO `t_pca` VALUES ('520403', '平坝区', null, '1');
INSERT INTO `t_pca` VALUES ('520422', '普定县', null, '1');
INSERT INTO `t_pca` VALUES ('520423', '镇宁布依族苗族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('520424', '关岭布依族苗族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('520425', '紫云苗族布依族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('520500', '毕节市', null, '1');
INSERT INTO `t_pca` VALUES ('520502', '七星关区', null, '1');
INSERT INTO `t_pca` VALUES ('520521', '大方县', null, '1');
INSERT INTO `t_pca` VALUES ('520522', '黔西县', null, '1');
INSERT INTO `t_pca` VALUES ('520523', '金沙县', null, '1');
INSERT INTO `t_pca` VALUES ('520524', '织金县', null, '1');
INSERT INTO `t_pca` VALUES ('520525', '纳雍县', null, '1');
INSERT INTO `t_pca` VALUES ('520526', '威宁彝族回族苗族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('520527', '赫章县', null, '1');
INSERT INTO `t_pca` VALUES ('520600', '铜仁市', null, '1');
INSERT INTO `t_pca` VALUES ('520602', '碧江区', null, '1');
INSERT INTO `t_pca` VALUES ('520603', '万山区', null, '1');
INSERT INTO `t_pca` VALUES ('520621', '江口县', null, '1');
INSERT INTO `t_pca` VALUES ('520622', '玉屏侗族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('520623', '石阡县', null, '1');
INSERT INTO `t_pca` VALUES ('520624', '思南县', null, '1');
INSERT INTO `t_pca` VALUES ('520625', '印江土家族苗族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('520626', '德江县', null, '1');
INSERT INTO `t_pca` VALUES ('520627', '沿河土家族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('520628', '松桃苗族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('522300', '黔西南布依族苗族自治州', null, '1');
INSERT INTO `t_pca` VALUES ('522301', '兴义市', null, '1');
INSERT INTO `t_pca` VALUES ('522322', '兴仁县', null, '1');
INSERT INTO `t_pca` VALUES ('522323', '普安县', null, '1');
INSERT INTO `t_pca` VALUES ('522324', '晴隆县', null, '1');
INSERT INTO `t_pca` VALUES ('522325', '贞丰县', null, '1');
INSERT INTO `t_pca` VALUES ('522326', '望谟县', null, '1');
INSERT INTO `t_pca` VALUES ('522327', '册亨县', null, '1');
INSERT INTO `t_pca` VALUES ('522328', '安龙县', null, '1');
INSERT INTO `t_pca` VALUES ('522600', '黔东南苗族侗族自治州', null, '1');
INSERT INTO `t_pca` VALUES ('522601', '凯里市', null, '1');
INSERT INTO `t_pca` VALUES ('522622', '黄平县', null, '1');
INSERT INTO `t_pca` VALUES ('522623', '施秉县', null, '1');
INSERT INTO `t_pca` VALUES ('522624', '三穗县', null, '1');
INSERT INTO `t_pca` VALUES ('522625', '镇远县', null, '1');
INSERT INTO `t_pca` VALUES ('522626', '岑巩县', null, '1');
INSERT INTO `t_pca` VALUES ('522627', '天柱县', null, '1');
INSERT INTO `t_pca` VALUES ('522628', '锦屏县', null, '1');
INSERT INTO `t_pca` VALUES ('522629', '剑河县', null, '1');
INSERT INTO `t_pca` VALUES ('522630', '台江县', null, '1');
INSERT INTO `t_pca` VALUES ('522631', '黎平县', null, '1');
INSERT INTO `t_pca` VALUES ('522632', '榕江县', null, '1');
INSERT INTO `t_pca` VALUES ('522633', '从江县', null, '1');
INSERT INTO `t_pca` VALUES ('522634', '雷山县', null, '1');
INSERT INTO `t_pca` VALUES ('522635', '麻江县', null, '1');
INSERT INTO `t_pca` VALUES ('522636', '丹寨县', null, '1');
INSERT INTO `t_pca` VALUES ('522700', '黔南布依族苗族自治州', null, '1');
INSERT INTO `t_pca` VALUES ('522701', '都匀市', null, '1');
INSERT INTO `t_pca` VALUES ('522702', '福泉市', null, '1');
INSERT INTO `t_pca` VALUES ('522722', '荔波县', null, '1');
INSERT INTO `t_pca` VALUES ('522723', '贵定县', null, '1');
INSERT INTO `t_pca` VALUES ('522725', '瓮安县', null, '1');
INSERT INTO `t_pca` VALUES ('522726', '独山县', null, '1');
INSERT INTO `t_pca` VALUES ('522727', '平塘县', null, '1');
INSERT INTO `t_pca` VALUES ('522728', '罗甸县', null, '1');
INSERT INTO `t_pca` VALUES ('522729', '长顺县', null, '1');
INSERT INTO `t_pca` VALUES ('522730', '龙里县', null, '1');
INSERT INTO `t_pca` VALUES ('522731', '惠水县', null, '1');
INSERT INTO `t_pca` VALUES ('522732', '三都水族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('530000', '云南省', null, '1');
INSERT INTO `t_pca` VALUES ('530100', '昆明市', null, '1');
INSERT INTO `t_pca` VALUES ('530102', '五华区', null, '1');
INSERT INTO `t_pca` VALUES ('530103', '盘龙区', null, '1');
INSERT INTO `t_pca` VALUES ('530111', '官渡区', null, '1');
INSERT INTO `t_pca` VALUES ('530112', '西山区', null, '1');
INSERT INTO `t_pca` VALUES ('530113', '东川区', null, '1');
INSERT INTO `t_pca` VALUES ('530114', '呈贡区', null, '1');
INSERT INTO `t_pca` VALUES ('530115', '晋宁区', null, '1');
INSERT INTO `t_pca` VALUES ('530124', '富民县', null, '1');
INSERT INTO `t_pca` VALUES ('530125', '宜良县', null, '1');
INSERT INTO `t_pca` VALUES ('530126', '石林彝族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('530127', '嵩明县', null, '1');
INSERT INTO `t_pca` VALUES ('530128', '禄劝彝族苗族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('530129', '寻甸回族彝族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('530181', '安宁市', null, '1');
INSERT INTO `t_pca` VALUES ('530300', '曲靖市', null, '1');
INSERT INTO `t_pca` VALUES ('530302', '麒麟区', null, '1');
INSERT INTO `t_pca` VALUES ('530303', '沾益区', null, '1');
INSERT INTO `t_pca` VALUES ('530321', '马龙县', null, '1');
INSERT INTO `t_pca` VALUES ('530322', '陆良县', null, '1');
INSERT INTO `t_pca` VALUES ('530323', '师宗县', null, '1');
INSERT INTO `t_pca` VALUES ('530324', '罗平县', null, '1');
INSERT INTO `t_pca` VALUES ('530325', '富源县', null, '1');
INSERT INTO `t_pca` VALUES ('530326', '会泽县', null, '1');
INSERT INTO `t_pca` VALUES ('530381', '宣威市', null, '1');
INSERT INTO `t_pca` VALUES ('530400', '玉溪市', null, '1');
INSERT INTO `t_pca` VALUES ('530402', '红塔区', null, '1');
INSERT INTO `t_pca` VALUES ('530403', '江川区', null, '1');
INSERT INTO `t_pca` VALUES ('530422', '澄江县', null, '1');
INSERT INTO `t_pca` VALUES ('530423', '通海县', null, '1');
INSERT INTO `t_pca` VALUES ('530424', '华宁县', null, '1');
INSERT INTO `t_pca` VALUES ('530425', '易门县', null, '1');
INSERT INTO `t_pca` VALUES ('530426', '峨山彝族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('530427', '新平彝族傣族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('530428', '元江哈尼族彝族傣族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('530500', '保山市', null, '1');
INSERT INTO `t_pca` VALUES ('530502', '隆阳区', null, '1');
INSERT INTO `t_pca` VALUES ('530521', '施甸县', null, '1');
INSERT INTO `t_pca` VALUES ('530523', '龙陵县', null, '1');
INSERT INTO `t_pca` VALUES ('530524', '昌宁县', null, '1');
INSERT INTO `t_pca` VALUES ('530581', '腾冲市', null, '1');
INSERT INTO `t_pca` VALUES ('530600', '昭通市', null, '1');
INSERT INTO `t_pca` VALUES ('530602', '昭阳区', null, '1');
INSERT INTO `t_pca` VALUES ('530621', '鲁甸县', null, '1');
INSERT INTO `t_pca` VALUES ('530622', '巧家县', null, '1');
INSERT INTO `t_pca` VALUES ('530623', '盐津县', null, '1');
INSERT INTO `t_pca` VALUES ('530624', '大关县', null, '1');
INSERT INTO `t_pca` VALUES ('530625', '永善县', null, '1');
INSERT INTO `t_pca` VALUES ('530626', '绥江县', null, '1');
INSERT INTO `t_pca` VALUES ('530627', '镇雄县', null, '1');
INSERT INTO `t_pca` VALUES ('530628', '彝良县', null, '1');
INSERT INTO `t_pca` VALUES ('530629', '威信县', null, '1');
INSERT INTO `t_pca` VALUES ('530630', '水富县', null, '1');
INSERT INTO `t_pca` VALUES ('530700', '丽江市', null, '1');
INSERT INTO `t_pca` VALUES ('530702', '古城区', null, '1');
INSERT INTO `t_pca` VALUES ('530721', '玉龙纳西族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('530722', '永胜县', null, '1');
INSERT INTO `t_pca` VALUES ('530723', '华坪县', null, '1');
INSERT INTO `t_pca` VALUES ('530724', '宁蒗彝族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('530800', '普洱市', null, '1');
INSERT INTO `t_pca` VALUES ('530802', '思茅区', null, '1');
INSERT INTO `t_pca` VALUES ('530821', '宁洱哈尼族彝族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('530822', '墨江哈尼族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('530823', '景东彝族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('530824', '景谷傣族彝族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('530825', '镇沅彝族哈尼族拉祜族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('530826', '江城哈尼族彝族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('530827', '孟连傣族拉祜族佤族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('530828', '澜沧拉祜族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('530829', '西盟佤族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('530900', '临沧市', null, '1');
INSERT INTO `t_pca` VALUES ('530902', '临翔区', null, '1');
INSERT INTO `t_pca` VALUES ('530921', '凤庆县', null, '1');
INSERT INTO `t_pca` VALUES ('530922', '云县', null, '1');
INSERT INTO `t_pca` VALUES ('530923', '永德县', null, '1');
INSERT INTO `t_pca` VALUES ('530924', '镇康县', null, '1');
INSERT INTO `t_pca` VALUES ('530925', '双江拉祜族佤族布朗族傣族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('530926', '耿马傣族佤族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('530927', '沧源佤族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('532300', '楚雄彝族自治州', null, '1');
INSERT INTO `t_pca` VALUES ('532301', '楚雄市', null, '1');
INSERT INTO `t_pca` VALUES ('532322', '双柏县', null, '1');
INSERT INTO `t_pca` VALUES ('532323', '牟定县', null, '1');
INSERT INTO `t_pca` VALUES ('532324', '南华县', null, '1');
INSERT INTO `t_pca` VALUES ('532325', '姚安县', null, '1');
INSERT INTO `t_pca` VALUES ('532326', '大姚县', null, '1');
INSERT INTO `t_pca` VALUES ('532327', '永仁县', null, '1');
INSERT INTO `t_pca` VALUES ('532328', '元谋县', null, '1');
INSERT INTO `t_pca` VALUES ('532329', '武定县', null, '1');
INSERT INTO `t_pca` VALUES ('532331', '禄丰县', null, '1');
INSERT INTO `t_pca` VALUES ('532500', '红河哈尼族彝族自治州', null, '1');
INSERT INTO `t_pca` VALUES ('532501', '个旧市', null, '1');
INSERT INTO `t_pca` VALUES ('532502', '开远市', null, '1');
INSERT INTO `t_pca` VALUES ('532503', '蒙自市', null, '1');
INSERT INTO `t_pca` VALUES ('532504', '弥勒市', null, '1');
INSERT INTO `t_pca` VALUES ('532523', '屏边苗族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('532524', '建水县', null, '1');
INSERT INTO `t_pca` VALUES ('532525', '石屏县', null, '1');
INSERT INTO `t_pca` VALUES ('532527', '泸西县', null, '1');
INSERT INTO `t_pca` VALUES ('532528', '元阳县', null, '1');
INSERT INTO `t_pca` VALUES ('532529', '红河县', null, '1');
INSERT INTO `t_pca` VALUES ('532530', '金平苗族瑶族傣族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('532531', '绿春县', null, '1');
INSERT INTO `t_pca` VALUES ('532532', '河口瑶族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('532600', '文山壮族苗族自治州', null, '1');
INSERT INTO `t_pca` VALUES ('532601', '文山市', null, '1');
INSERT INTO `t_pca` VALUES ('532622', '砚山县', null, '1');
INSERT INTO `t_pca` VALUES ('532623', '西畴县', null, '1');
INSERT INTO `t_pca` VALUES ('532624', '麻栗坡县', null, '1');
INSERT INTO `t_pca` VALUES ('532625', '马关县', null, '1');
INSERT INTO `t_pca` VALUES ('532626', '丘北县', null, '1');
INSERT INTO `t_pca` VALUES ('532627', '广南县', null, '1');
INSERT INTO `t_pca` VALUES ('532628', '富宁县', null, '1');
INSERT INTO `t_pca` VALUES ('532800', '西双版纳傣族自治州', null, '1');
INSERT INTO `t_pca` VALUES ('532801', '景洪市', null, '1');
INSERT INTO `t_pca` VALUES ('532822', '勐海县', null, '1');
INSERT INTO `t_pca` VALUES ('532823', '勐腊县', null, '1');
INSERT INTO `t_pca` VALUES ('532900', '大理白族自治州', null, '1');
INSERT INTO `t_pca` VALUES ('532901', '大理市', null, '1');
INSERT INTO `t_pca` VALUES ('532922', '漾濞彝族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('532923', '祥云县', null, '1');
INSERT INTO `t_pca` VALUES ('532924', '宾川县', null, '1');
INSERT INTO `t_pca` VALUES ('532925', '弥渡县', null, '1');
INSERT INTO `t_pca` VALUES ('532926', '南涧彝族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('532927', '巍山彝族回族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('532928', '永平县', null, '1');
INSERT INTO `t_pca` VALUES ('532929', '云龙县', null, '1');
INSERT INTO `t_pca` VALUES ('532930', '洱源县', null, '1');
INSERT INTO `t_pca` VALUES ('532931', '剑川县', null, '1');
INSERT INTO `t_pca` VALUES ('532932', '鹤庆县', null, '1');
INSERT INTO `t_pca` VALUES ('533100', '德宏傣族景颇族自治州', null, '1');
INSERT INTO `t_pca` VALUES ('533102', '瑞丽市', null, '1');
INSERT INTO `t_pca` VALUES ('533103', '芒市', null, '1');
INSERT INTO `t_pca` VALUES ('533122', '梁河县', null, '1');
INSERT INTO `t_pca` VALUES ('533123', '盈江县', null, '1');
INSERT INTO `t_pca` VALUES ('533124', '陇川县', null, '1');
INSERT INTO `t_pca` VALUES ('533300', '怒江傈僳族自治州', null, '1');
INSERT INTO `t_pca` VALUES ('533301', '泸水市', null, '1');
INSERT INTO `t_pca` VALUES ('533323', '福贡县', null, '1');
INSERT INTO `t_pca` VALUES ('533324', '贡山独龙族怒族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('533325', '兰坪白族普米族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('533400', '迪庆藏族自治州', null, '1');
INSERT INTO `t_pca` VALUES ('533401', '香格里拉市', null, '1');
INSERT INTO `t_pca` VALUES ('533422', '德钦县', null, '1');
INSERT INTO `t_pca` VALUES ('533423', '维西傈僳族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('540000', '西藏自治区', null, '1');
INSERT INTO `t_pca` VALUES ('540100', '拉萨市', null, '1');
INSERT INTO `t_pca` VALUES ('540102', '城关区', null, '1');
INSERT INTO `t_pca` VALUES ('540103', '堆龙德庆区', null, '1');
INSERT INTO `t_pca` VALUES ('540104', '达孜区', null, '1');
INSERT INTO `t_pca` VALUES ('540121', '林周县', null, '1');
INSERT INTO `t_pca` VALUES ('540122', '当雄县', null, '1');
INSERT INTO `t_pca` VALUES ('540123', '尼木县', null, '1');
INSERT INTO `t_pca` VALUES ('540124', '曲水县', null, '1');
INSERT INTO `t_pca` VALUES ('540127', '墨竹工卡县', null, '1');
INSERT INTO `t_pca` VALUES ('540200', '日喀则市', null, '1');
INSERT INTO `t_pca` VALUES ('540202', '桑珠孜区', null, '1');
INSERT INTO `t_pca` VALUES ('540221', '南木林县', null, '1');
INSERT INTO `t_pca` VALUES ('540222', '江孜县', null, '1');
INSERT INTO `t_pca` VALUES ('540223', '定日县', null, '1');
INSERT INTO `t_pca` VALUES ('540224', '萨迦县', null, '1');
INSERT INTO `t_pca` VALUES ('540225', '拉孜县', null, '1');
INSERT INTO `t_pca` VALUES ('540226', '昂仁县', null, '1');
INSERT INTO `t_pca` VALUES ('540227', '谢通门县', null, '1');
INSERT INTO `t_pca` VALUES ('540228', '白朗县', null, '1');
INSERT INTO `t_pca` VALUES ('540229', '仁布县', null, '1');
INSERT INTO `t_pca` VALUES ('540230', '康马县', null, '1');
INSERT INTO `t_pca` VALUES ('540231', '定结县', null, '1');
INSERT INTO `t_pca` VALUES ('540232', '仲巴县', null, '1');
INSERT INTO `t_pca` VALUES ('540233', '亚东县', null, '1');
INSERT INTO `t_pca` VALUES ('540234', '吉隆县', null, '1');
INSERT INTO `t_pca` VALUES ('540235', '聂拉木县', null, '1');
INSERT INTO `t_pca` VALUES ('540236', '萨嘎县', null, '1');
INSERT INTO `t_pca` VALUES ('540237', '岗巴县', null, '1');
INSERT INTO `t_pca` VALUES ('540300', '昌都市', null, '1');
INSERT INTO `t_pca` VALUES ('540302', '卡若区', null, '1');
INSERT INTO `t_pca` VALUES ('540321', '江达县', null, '1');
INSERT INTO `t_pca` VALUES ('540322', '贡觉县', null, '1');
INSERT INTO `t_pca` VALUES ('540323', '类乌齐县', null, '1');
INSERT INTO `t_pca` VALUES ('540324', '丁青县', null, '1');
INSERT INTO `t_pca` VALUES ('540325', '察雅县', null, '1');
INSERT INTO `t_pca` VALUES ('540326', '八宿县', null, '1');
INSERT INTO `t_pca` VALUES ('540327', '左贡县', null, '1');
INSERT INTO `t_pca` VALUES ('540328', '芒康县', null, '1');
INSERT INTO `t_pca` VALUES ('540329', '洛隆县', null, '1');
INSERT INTO `t_pca` VALUES ('540330', '边坝县', null, '1');
INSERT INTO `t_pca` VALUES ('540400', '林芝市', null, '1');
INSERT INTO `t_pca` VALUES ('540402', '巴宜区', null, '1');
INSERT INTO `t_pca` VALUES ('540421', '工布江达县', null, '1');
INSERT INTO `t_pca` VALUES ('540422', '米林县', null, '1');
INSERT INTO `t_pca` VALUES ('540423', '墨脱县', null, '1');
INSERT INTO `t_pca` VALUES ('540424', '波密县', null, '1');
INSERT INTO `t_pca` VALUES ('540425', '察隅县', null, '1');
INSERT INTO `t_pca` VALUES ('540426', '朗县', null, '1');
INSERT INTO `t_pca` VALUES ('540500', '山南市', null, '1');
INSERT INTO `t_pca` VALUES ('540502', '乃东区', null, '1');
INSERT INTO `t_pca` VALUES ('540521', '扎囊县', null, '1');
INSERT INTO `t_pca` VALUES ('540522', '贡嘎县', null, '1');
INSERT INTO `t_pca` VALUES ('540523', '桑日县', null, '1');
INSERT INTO `t_pca` VALUES ('540524', '琼结县', null, '1');
INSERT INTO `t_pca` VALUES ('540525', '曲松县', null, '1');
INSERT INTO `t_pca` VALUES ('540526', '措美县', null, '1');
INSERT INTO `t_pca` VALUES ('540527', '洛扎县', null, '1');
INSERT INTO `t_pca` VALUES ('540528', '加查县', null, '1');
INSERT INTO `t_pca` VALUES ('540529', '隆子县', null, '1');
INSERT INTO `t_pca` VALUES ('540530', '错那县', null, '1');
INSERT INTO `t_pca` VALUES ('540531', '浪卡子县', null, '1');
INSERT INTO `t_pca` VALUES ('540600', '那曲市', null, '1');
INSERT INTO `t_pca` VALUES ('540602', '色尼区', null, '1');
INSERT INTO `t_pca` VALUES ('540621', '嘉黎县 ', null, '1');
INSERT INTO `t_pca` VALUES ('540622', '比如县 ', null, '1');
INSERT INTO `t_pca` VALUES ('540623', '聂荣县 ', null, '1');
INSERT INTO `t_pca` VALUES ('540624', '安多县 ', null, '1');
INSERT INTO `t_pca` VALUES ('540625', '申扎县 ', null, '1');
INSERT INTO `t_pca` VALUES ('540626', '索县   ', null, '1');
INSERT INTO `t_pca` VALUES ('540627', '班戈县 ', null, '1');
INSERT INTO `t_pca` VALUES ('540628', '巴青县 ', null, '1');
INSERT INTO `t_pca` VALUES ('540629', '尼玛县 ', null, '1');
INSERT INTO `t_pca` VALUES ('540630', '双湖县 ', null, '1');
INSERT INTO `t_pca` VALUES ('542500', '阿里地区', null, '1');
INSERT INTO `t_pca` VALUES ('542521', '普兰县', null, '1');
INSERT INTO `t_pca` VALUES ('542522', '札达县', null, '1');
INSERT INTO `t_pca` VALUES ('542523', '噶尔县', null, '1');
INSERT INTO `t_pca` VALUES ('542524', '日土县', null, '1');
INSERT INTO `t_pca` VALUES ('542525', '革吉县', null, '1');
INSERT INTO `t_pca` VALUES ('542526', '改则县', null, '1');
INSERT INTO `t_pca` VALUES ('542527', '措勤县', null, '1');
INSERT INTO `t_pca` VALUES ('610000', '陕西省', null, '1');
INSERT INTO `t_pca` VALUES ('610100', '西安市', null, '1');
INSERT INTO `t_pca` VALUES ('610102', '新城区', null, '1');
INSERT INTO `t_pca` VALUES ('610103', '碑林区', null, '1');
INSERT INTO `t_pca` VALUES ('610104', '莲湖区', null, '1');
INSERT INTO `t_pca` VALUES ('610111', '灞桥区', null, '1');
INSERT INTO `t_pca` VALUES ('610112', '未央区', null, '1');
INSERT INTO `t_pca` VALUES ('610113', '雁塔区', null, '1');
INSERT INTO `t_pca` VALUES ('610114', '阎良区', null, '1');
INSERT INTO `t_pca` VALUES ('610115', '临潼区', null, '1');
INSERT INTO `t_pca` VALUES ('610116', '长安区', null, '1');
INSERT INTO `t_pca` VALUES ('610117', '高陵区', null, '1');
INSERT INTO `t_pca` VALUES ('610118', '鄠邑区', null, '1');
INSERT INTO `t_pca` VALUES ('610122', '蓝田县', null, '1');
INSERT INTO `t_pca` VALUES ('610124', '周至县', null, '1');
INSERT INTO `t_pca` VALUES ('610200', '铜川市', null, '1');
INSERT INTO `t_pca` VALUES ('610202', '王益区', null, '1');
INSERT INTO `t_pca` VALUES ('610203', '印台区', null, '1');
INSERT INTO `t_pca` VALUES ('610204', '耀州区', null, '1');
INSERT INTO `t_pca` VALUES ('610222', '宜君县', null, '1');
INSERT INTO `t_pca` VALUES ('610300', '宝鸡市', null, '1');
INSERT INTO `t_pca` VALUES ('610302', '渭滨区', null, '1');
INSERT INTO `t_pca` VALUES ('610303', '金台区', null, '1');
INSERT INTO `t_pca` VALUES ('610304', '陈仓区', null, '1');
INSERT INTO `t_pca` VALUES ('610322', '凤翔县', null, '1');
INSERT INTO `t_pca` VALUES ('610323', '岐山县', null, '1');
INSERT INTO `t_pca` VALUES ('610324', '扶风县', null, '1');
INSERT INTO `t_pca` VALUES ('610326', '眉县', null, '1');
INSERT INTO `t_pca` VALUES ('610327', '陇县', null, '1');
INSERT INTO `t_pca` VALUES ('610328', '千阳县', null, '1');
INSERT INTO `t_pca` VALUES ('610329', '麟游县', null, '1');
INSERT INTO `t_pca` VALUES ('610330', '凤县', null, '1');
INSERT INTO `t_pca` VALUES ('610331', '太白县', null, '1');
INSERT INTO `t_pca` VALUES ('610400', '咸阳市', null, '1');
INSERT INTO `t_pca` VALUES ('610402', '秦都区', null, '1');
INSERT INTO `t_pca` VALUES ('610403', '杨陵区', null, '1');
INSERT INTO `t_pca` VALUES ('610404', '渭城区', null, '1');
INSERT INTO `t_pca` VALUES ('610422', '三原县', null, '1');
INSERT INTO `t_pca` VALUES ('610423', '泾阳县', null, '1');
INSERT INTO `t_pca` VALUES ('610424', '乾县', null, '1');
INSERT INTO `t_pca` VALUES ('610425', '礼泉县', null, '1');
INSERT INTO `t_pca` VALUES ('610426', '永寿县', null, '1');
INSERT INTO `t_pca` VALUES ('610427', '彬县', null, '1');
INSERT INTO `t_pca` VALUES ('610428', '长武县', null, '1');
INSERT INTO `t_pca` VALUES ('610429', '旬邑县', null, '1');
INSERT INTO `t_pca` VALUES ('610430', '淳化县', null, '1');
INSERT INTO `t_pca` VALUES ('610431', '武功县', null, '1');
INSERT INTO `t_pca` VALUES ('610481', '兴平市', null, '1');
INSERT INTO `t_pca` VALUES ('610500', '渭南市', null, '1');
INSERT INTO `t_pca` VALUES ('610502', '临渭区', null, '1');
INSERT INTO `t_pca` VALUES ('610503', '华州区', null, '1');
INSERT INTO `t_pca` VALUES ('610522', '潼关县', null, '1');
INSERT INTO `t_pca` VALUES ('610523', '大荔县', null, '1');
INSERT INTO `t_pca` VALUES ('610524', '合阳县', null, '1');
INSERT INTO `t_pca` VALUES ('610525', '澄城县', null, '1');
INSERT INTO `t_pca` VALUES ('610526', '蒲城县', null, '1');
INSERT INTO `t_pca` VALUES ('610527', '白水县', null, '1');
INSERT INTO `t_pca` VALUES ('610528', '富平县', null, '1');
INSERT INTO `t_pca` VALUES ('610581', '韩城市', null, '1');
INSERT INTO `t_pca` VALUES ('610582', '华阴市', null, '1');
INSERT INTO `t_pca` VALUES ('610600', '延安市', null, '1');
INSERT INTO `t_pca` VALUES ('610602', '宝塔区', null, '1');
INSERT INTO `t_pca` VALUES ('610603', '安塞区', null, '1');
INSERT INTO `t_pca` VALUES ('610621', '延长县', null, '1');
INSERT INTO `t_pca` VALUES ('610622', '延川县', null, '1');
INSERT INTO `t_pca` VALUES ('610623', '子长县', null, '1');
INSERT INTO `t_pca` VALUES ('610625', '志丹县', null, '1');
INSERT INTO `t_pca` VALUES ('610626', '吴起县', null, '1');
INSERT INTO `t_pca` VALUES ('610627', '甘泉县', null, '1');
INSERT INTO `t_pca` VALUES ('610628', '富县', null, '1');
INSERT INTO `t_pca` VALUES ('610629', '洛川县', null, '1');
INSERT INTO `t_pca` VALUES ('610630', '宜川县', null, '1');
INSERT INTO `t_pca` VALUES ('610631', '黄龙县', null, '1');
INSERT INTO `t_pca` VALUES ('610632', '黄陵县', null, '1');
INSERT INTO `t_pca` VALUES ('610700', '汉中市', null, '1');
INSERT INTO `t_pca` VALUES ('610702', '汉台区', null, '1');
INSERT INTO `t_pca` VALUES ('610703', '南郑区', null, '1');
INSERT INTO `t_pca` VALUES ('610722', '城固县', null, '1');
INSERT INTO `t_pca` VALUES ('610723', '洋县', null, '1');
INSERT INTO `t_pca` VALUES ('610724', '西乡县', null, '1');
INSERT INTO `t_pca` VALUES ('610725', '勉县', null, '1');
INSERT INTO `t_pca` VALUES ('610726', '宁强县', null, '1');
INSERT INTO `t_pca` VALUES ('610727', '略阳县', null, '1');
INSERT INTO `t_pca` VALUES ('610728', '镇巴县', null, '1');
INSERT INTO `t_pca` VALUES ('610729', '留坝县', null, '1');
INSERT INTO `t_pca` VALUES ('610730', '佛坪县', null, '1');
INSERT INTO `t_pca` VALUES ('610800', '榆林市', null, '1');
INSERT INTO `t_pca` VALUES ('610802', '榆阳区', null, '1');
INSERT INTO `t_pca` VALUES ('610803', '横山区', null, '1');
INSERT INTO `t_pca` VALUES ('610822', '府谷县', null, '1');
INSERT INTO `t_pca` VALUES ('610824', '靖边县', null, '1');
INSERT INTO `t_pca` VALUES ('610825', '定边县', null, '1');
INSERT INTO `t_pca` VALUES ('610826', '绥德县', null, '1');
INSERT INTO `t_pca` VALUES ('610827', '米脂县', null, '1');
INSERT INTO `t_pca` VALUES ('610828', '佳县', null, '1');
INSERT INTO `t_pca` VALUES ('610829', '吴堡县', null, '1');
INSERT INTO `t_pca` VALUES ('610830', '清涧县', null, '1');
INSERT INTO `t_pca` VALUES ('610831', '子洲县', null, '1');
INSERT INTO `t_pca` VALUES ('610881', '神木市', null, '1');
INSERT INTO `t_pca` VALUES ('610900', '安康市', null, '1');
INSERT INTO `t_pca` VALUES ('610902', '汉滨区', null, '1');
INSERT INTO `t_pca` VALUES ('610921', '汉阴县', null, '1');
INSERT INTO `t_pca` VALUES ('610922', '石泉县', null, '1');
INSERT INTO `t_pca` VALUES ('610923', '宁陕县', null, '1');
INSERT INTO `t_pca` VALUES ('610924', '紫阳县', null, '1');
INSERT INTO `t_pca` VALUES ('610925', '岚皋县', null, '1');
INSERT INTO `t_pca` VALUES ('610926', '平利县', null, '1');
INSERT INTO `t_pca` VALUES ('610927', '镇坪县', null, '1');
INSERT INTO `t_pca` VALUES ('610928', '旬阳县', null, '1');
INSERT INTO `t_pca` VALUES ('610929', '白河县', null, '1');
INSERT INTO `t_pca` VALUES ('611000', '商洛市', null, '1');
INSERT INTO `t_pca` VALUES ('611002', '商州区', null, '1');
INSERT INTO `t_pca` VALUES ('611021', '洛南县', null, '1');
INSERT INTO `t_pca` VALUES ('611022', '丹凤县', null, '1');
INSERT INTO `t_pca` VALUES ('611023', '商南县', null, '1');
INSERT INTO `t_pca` VALUES ('611024', '山阳县', null, '1');
INSERT INTO `t_pca` VALUES ('611025', '镇安县', null, '1');
INSERT INTO `t_pca` VALUES ('611026', '柞水县', null, '1');
INSERT INTO `t_pca` VALUES ('620000', '甘肃省', null, '1');
INSERT INTO `t_pca` VALUES ('620100', '兰州市', null, '1');
INSERT INTO `t_pca` VALUES ('620102', '城关区', null, '1');
INSERT INTO `t_pca` VALUES ('620103', '七里河区', null, '1');
INSERT INTO `t_pca` VALUES ('620104', '西固区', null, '1');
INSERT INTO `t_pca` VALUES ('620105', '安宁区', null, '1');
INSERT INTO `t_pca` VALUES ('620111', '红古区', null, '1');
INSERT INTO `t_pca` VALUES ('620121', '永登县', null, '1');
INSERT INTO `t_pca` VALUES ('620122', '皋兰县', null, '1');
INSERT INTO `t_pca` VALUES ('620123', '榆中县', null, '1');
INSERT INTO `t_pca` VALUES ('620200', '嘉峪关市', null, '1');
INSERT INTO `t_pca` VALUES ('620300', '金昌市', null, '1');
INSERT INTO `t_pca` VALUES ('620302', '金川区', null, '1');
INSERT INTO `t_pca` VALUES ('620321', '永昌县', null, '1');
INSERT INTO `t_pca` VALUES ('620400', '白银市', null, '1');
INSERT INTO `t_pca` VALUES ('620402', '白银区', null, '1');
INSERT INTO `t_pca` VALUES ('620403', '平川区', null, '1');
INSERT INTO `t_pca` VALUES ('620421', '靖远县', null, '1');
INSERT INTO `t_pca` VALUES ('620422', '会宁县', null, '1');
INSERT INTO `t_pca` VALUES ('620423', '景泰县', null, '1');
INSERT INTO `t_pca` VALUES ('620500', '天水市', null, '1');
INSERT INTO `t_pca` VALUES ('620502', '秦州区', null, '1');
INSERT INTO `t_pca` VALUES ('620503', '麦积区', null, '1');
INSERT INTO `t_pca` VALUES ('620521', '清水县', null, '1');
INSERT INTO `t_pca` VALUES ('620522', '秦安县', null, '1');
INSERT INTO `t_pca` VALUES ('620523', '甘谷县', null, '1');
INSERT INTO `t_pca` VALUES ('620524', '武山县', null, '1');
INSERT INTO `t_pca` VALUES ('620525', '张家川回族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('620600', '武威市', null, '1');
INSERT INTO `t_pca` VALUES ('620602', '凉州区', null, '1');
INSERT INTO `t_pca` VALUES ('620621', '民勤县', null, '1');
INSERT INTO `t_pca` VALUES ('620622', '古浪县', null, '1');
INSERT INTO `t_pca` VALUES ('620623', '天祝藏族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('620700', '张掖市', null, '1');
INSERT INTO `t_pca` VALUES ('620702', '甘州区', null, '1');
INSERT INTO `t_pca` VALUES ('620721', '肃南裕固族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('620722', '民乐县', null, '1');
INSERT INTO `t_pca` VALUES ('620723', '临泽县', null, '1');
INSERT INTO `t_pca` VALUES ('620724', '高台县', null, '1');
INSERT INTO `t_pca` VALUES ('620725', '山丹县', null, '1');
INSERT INTO `t_pca` VALUES ('620800', '平凉市', null, '1');
INSERT INTO `t_pca` VALUES ('620802', '崆峒区', null, '1');
INSERT INTO `t_pca` VALUES ('620821', '泾川县', null, '1');
INSERT INTO `t_pca` VALUES ('620822', '灵台县', null, '1');
INSERT INTO `t_pca` VALUES ('620823', '崇信县', null, '1');
INSERT INTO `t_pca` VALUES ('620824', '华亭县', null, '1');
INSERT INTO `t_pca` VALUES ('620825', '庄浪县', null, '1');
INSERT INTO `t_pca` VALUES ('620826', '静宁县', null, '1');
INSERT INTO `t_pca` VALUES ('620900', '酒泉市', null, '1');
INSERT INTO `t_pca` VALUES ('620902', '肃州区', null, '1');
INSERT INTO `t_pca` VALUES ('620921', '金塔县', null, '1');
INSERT INTO `t_pca` VALUES ('620922', '瓜州县', null, '1');
INSERT INTO `t_pca` VALUES ('620923', '肃北蒙古族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('620924', '阿克塞哈萨克族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('620981', '玉门市', null, '1');
INSERT INTO `t_pca` VALUES ('620982', '敦煌市', null, '1');
INSERT INTO `t_pca` VALUES ('621000', '庆阳市', null, '1');
INSERT INTO `t_pca` VALUES ('621002', '西峰区', null, '1');
INSERT INTO `t_pca` VALUES ('621021', '庆城县', null, '1');
INSERT INTO `t_pca` VALUES ('621022', '环县', null, '1');
INSERT INTO `t_pca` VALUES ('621023', '华池县', null, '1');
INSERT INTO `t_pca` VALUES ('621024', '合水县', null, '1');
INSERT INTO `t_pca` VALUES ('621025', '正宁县', null, '1');
INSERT INTO `t_pca` VALUES ('621026', '宁县', null, '1');
INSERT INTO `t_pca` VALUES ('621027', '镇原县', null, '1');
INSERT INTO `t_pca` VALUES ('621100', '定西市', null, '1');
INSERT INTO `t_pca` VALUES ('621102', '安定区', null, '1');
INSERT INTO `t_pca` VALUES ('621121', '通渭县', null, '1');
INSERT INTO `t_pca` VALUES ('621122', '陇西县', null, '1');
INSERT INTO `t_pca` VALUES ('621123', '渭源县', null, '1');
INSERT INTO `t_pca` VALUES ('621124', '临洮县', null, '1');
INSERT INTO `t_pca` VALUES ('621125', '漳县', null, '1');
INSERT INTO `t_pca` VALUES ('621126', '岷县', null, '1');
INSERT INTO `t_pca` VALUES ('621200', '陇南市', null, '1');
INSERT INTO `t_pca` VALUES ('621202', '武都区', null, '1');
INSERT INTO `t_pca` VALUES ('621221', '成县', null, '1');
INSERT INTO `t_pca` VALUES ('621222', '文县', null, '1');
INSERT INTO `t_pca` VALUES ('621223', '宕昌县', null, '1');
INSERT INTO `t_pca` VALUES ('621224', '康县', null, '1');
INSERT INTO `t_pca` VALUES ('621225', '西和县', null, '1');
INSERT INTO `t_pca` VALUES ('621226', '礼县', null, '1');
INSERT INTO `t_pca` VALUES ('621227', '徽县', null, '1');
INSERT INTO `t_pca` VALUES ('621228', '两当县', null, '1');
INSERT INTO `t_pca` VALUES ('622900', '临夏回族自治州', null, '1');
INSERT INTO `t_pca` VALUES ('622901', '临夏市', null, '1');
INSERT INTO `t_pca` VALUES ('622921', '临夏县', null, '1');
INSERT INTO `t_pca` VALUES ('622922', '康乐县', null, '1');
INSERT INTO `t_pca` VALUES ('622923', '永靖县', null, '1');
INSERT INTO `t_pca` VALUES ('622924', '广河县', null, '1');
INSERT INTO `t_pca` VALUES ('622925', '和政县', null, '1');
INSERT INTO `t_pca` VALUES ('622926', '东乡族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('622927', '积石山保安族东乡族撒拉族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('623000', '甘南藏族自治州', null, '1');
INSERT INTO `t_pca` VALUES ('623001', '合作市', null, '1');
INSERT INTO `t_pca` VALUES ('623021', '临潭县', null, '1');
INSERT INTO `t_pca` VALUES ('623022', '卓尼县', null, '1');
INSERT INTO `t_pca` VALUES ('623023', '舟曲县', null, '1');
INSERT INTO `t_pca` VALUES ('623024', '迭部县', null, '1');
INSERT INTO `t_pca` VALUES ('623025', '玛曲县', null, '1');
INSERT INTO `t_pca` VALUES ('623026', '碌曲县', null, '1');
INSERT INTO `t_pca` VALUES ('623027', '夏河县', null, '1');
INSERT INTO `t_pca` VALUES ('630000', '青海省', null, '1');
INSERT INTO `t_pca` VALUES ('630100', '西宁市', null, '1');
INSERT INTO `t_pca` VALUES ('630102', '城东区', null, '1');
INSERT INTO `t_pca` VALUES ('630103', '城中区', null, '1');
INSERT INTO `t_pca` VALUES ('630104', '城西区', null, '1');
INSERT INTO `t_pca` VALUES ('630105', '城北区', null, '1');
INSERT INTO `t_pca` VALUES ('630121', '大通回族土族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('630122', '湟中县', null, '1');
INSERT INTO `t_pca` VALUES ('630123', '湟源县', null, '1');
INSERT INTO `t_pca` VALUES ('630200', '海东市', null, '1');
INSERT INTO `t_pca` VALUES ('630202', '乐都区', null, '1');
INSERT INTO `t_pca` VALUES ('630203', '平安区', null, '1');
INSERT INTO `t_pca` VALUES ('630222', '民和回族土族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('630223', '互助土族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('630224', '化隆回族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('630225', '循化撒拉族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('632200', '海北藏族自治州', null, '1');
INSERT INTO `t_pca` VALUES ('632221', '门源回族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('632222', '祁连县', null, '1');
INSERT INTO `t_pca` VALUES ('632223', '海晏县', null, '1');
INSERT INTO `t_pca` VALUES ('632224', '刚察县', null, '1');
INSERT INTO `t_pca` VALUES ('632300', '黄南藏族自治州', null, '1');
INSERT INTO `t_pca` VALUES ('632321', '同仁县', null, '1');
INSERT INTO `t_pca` VALUES ('632322', '尖扎县', null, '1');
INSERT INTO `t_pca` VALUES ('632323', '泽库县', null, '1');
INSERT INTO `t_pca` VALUES ('632324', '河南蒙古族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('632500', '海南藏族自治州', null, '1');
INSERT INTO `t_pca` VALUES ('632521', '共和县', null, '1');
INSERT INTO `t_pca` VALUES ('632522', '同德县', null, '1');
INSERT INTO `t_pca` VALUES ('632523', '贵德县', null, '1');
INSERT INTO `t_pca` VALUES ('632524', '兴海县', null, '1');
INSERT INTO `t_pca` VALUES ('632525', '贵南县', null, '1');
INSERT INTO `t_pca` VALUES ('632600', '果洛藏族自治州', null, '1');
INSERT INTO `t_pca` VALUES ('632621', '玛沁县', null, '1');
INSERT INTO `t_pca` VALUES ('632622', '班玛县', null, '1');
INSERT INTO `t_pca` VALUES ('632623', '甘德县', null, '1');
INSERT INTO `t_pca` VALUES ('632624', '达日县', null, '1');
INSERT INTO `t_pca` VALUES ('632625', '久治县', null, '1');
INSERT INTO `t_pca` VALUES ('632626', '玛多县', null, '1');
INSERT INTO `t_pca` VALUES ('632700', '玉树藏族自治州', null, '1');
INSERT INTO `t_pca` VALUES ('632701', '玉树市', null, '1');
INSERT INTO `t_pca` VALUES ('632722', '杂多县', null, '1');
INSERT INTO `t_pca` VALUES ('632723', '称多县', null, '1');
INSERT INTO `t_pca` VALUES ('632724', '治多县', null, '1');
INSERT INTO `t_pca` VALUES ('632725', '囊谦县', null, '1');
INSERT INTO `t_pca` VALUES ('632726', '曲麻莱县', null, '1');
INSERT INTO `t_pca` VALUES ('632800', '海西蒙古族藏族自治州', null, '1');
INSERT INTO `t_pca` VALUES ('632801', '格尔木市', null, '1');
INSERT INTO `t_pca` VALUES ('632802', '德令哈市', null, '1');
INSERT INTO `t_pca` VALUES ('632821', '乌兰县', null, '1');
INSERT INTO `t_pca` VALUES ('632822', '都兰县', null, '1');
INSERT INTO `t_pca` VALUES ('632823', '天峻县', null, '1');
INSERT INTO `t_pca` VALUES ('640000', '宁夏回族自治区', null, '1');
INSERT INTO `t_pca` VALUES ('640100', '银川市', null, '1');
INSERT INTO `t_pca` VALUES ('640104', '兴庆区', null, '1');
INSERT INTO `t_pca` VALUES ('640105', '西夏区', null, '1');
INSERT INTO `t_pca` VALUES ('640106', '金凤区', null, '1');
INSERT INTO `t_pca` VALUES ('640121', '永宁县', null, '1');
INSERT INTO `t_pca` VALUES ('640122', '贺兰县', null, '1');
INSERT INTO `t_pca` VALUES ('640181', '灵武市', null, '1');
INSERT INTO `t_pca` VALUES ('640200', '石嘴山市', null, '1');
INSERT INTO `t_pca` VALUES ('640202', '大武口区', null, '1');
INSERT INTO `t_pca` VALUES ('640205', '惠农区', null, '1');
INSERT INTO `t_pca` VALUES ('640221', '平罗县', null, '1');
INSERT INTO `t_pca` VALUES ('640300', '吴忠市', null, '1');
INSERT INTO `t_pca` VALUES ('640302', '利通区', null, '1');
INSERT INTO `t_pca` VALUES ('640303', '红寺堡区', null, '1');
INSERT INTO `t_pca` VALUES ('640323', '盐池县', null, '1');
INSERT INTO `t_pca` VALUES ('640324', '同心县', null, '1');
INSERT INTO `t_pca` VALUES ('640381', '青铜峡市', null, '1');
INSERT INTO `t_pca` VALUES ('640400', '固原市', null, '1');
INSERT INTO `t_pca` VALUES ('640402', '原州区', null, '1');
INSERT INTO `t_pca` VALUES ('640422', '西吉县', null, '1');
INSERT INTO `t_pca` VALUES ('640423', '隆德县', null, '1');
INSERT INTO `t_pca` VALUES ('640424', '泾源县', null, '1');
INSERT INTO `t_pca` VALUES ('640425', '彭阳县', null, '1');
INSERT INTO `t_pca` VALUES ('640500', '中卫市', null, '1');
INSERT INTO `t_pca` VALUES ('640502', '沙坡头区', null, '1');
INSERT INTO `t_pca` VALUES ('640521', '中宁县', null, '1');
INSERT INTO `t_pca` VALUES ('640522', '海原县', null, '1');
INSERT INTO `t_pca` VALUES ('650000', '新疆维吾尔自治区', null, '1');
INSERT INTO `t_pca` VALUES ('650100', '乌鲁木齐市', null, '1');
INSERT INTO `t_pca` VALUES ('650102', '天山区', null, '1');
INSERT INTO `t_pca` VALUES ('650103', '沙依巴克区', null, '1');
INSERT INTO `t_pca` VALUES ('650104', '新市区', null, '1');
INSERT INTO `t_pca` VALUES ('650105', '水磨沟区', null, '1');
INSERT INTO `t_pca` VALUES ('650106', '头屯河区', null, '1');
INSERT INTO `t_pca` VALUES ('650107', '达坂城区', null, '1');
INSERT INTO `t_pca` VALUES ('650109', '米东区', null, '1');
INSERT INTO `t_pca` VALUES ('650121', '乌鲁木齐县', null, '1');
INSERT INTO `t_pca` VALUES ('650200', '克拉玛依市', null, '1');
INSERT INTO `t_pca` VALUES ('650202', '独山子区', null, '1');
INSERT INTO `t_pca` VALUES ('650203', '克拉玛依区', null, '1');
INSERT INTO `t_pca` VALUES ('650204', '白碱滩区', null, '1');
INSERT INTO `t_pca` VALUES ('650205', '乌尔禾区', null, '1');
INSERT INTO `t_pca` VALUES ('650400', '吐鲁番市', null, '1');
INSERT INTO `t_pca` VALUES ('650402', '高昌区', null, '1');
INSERT INTO `t_pca` VALUES ('650421', '鄯善县', null, '1');
INSERT INTO `t_pca` VALUES ('650422', '托克逊县', null, '1');
INSERT INTO `t_pca` VALUES ('650500', '哈密市', null, '1');
INSERT INTO `t_pca` VALUES ('650502', '伊州区', null, '1');
INSERT INTO `t_pca` VALUES ('650521', '巴里坤哈萨克自治县', null, '1');
INSERT INTO `t_pca` VALUES ('650522', '伊吾县', null, '1');
INSERT INTO `t_pca` VALUES ('652300', '昌吉回族自治州', null, '1');
INSERT INTO `t_pca` VALUES ('652301', '昌吉市', null, '1');
INSERT INTO `t_pca` VALUES ('652302', '阜康市', null, '1');
INSERT INTO `t_pca` VALUES ('652323', '呼图壁县', null, '1');
INSERT INTO `t_pca` VALUES ('652324', '玛纳斯县', null, '1');
INSERT INTO `t_pca` VALUES ('652325', '奇台县', null, '1');
INSERT INTO `t_pca` VALUES ('652327', '吉木萨尔县', null, '1');
INSERT INTO `t_pca` VALUES ('652328', '木垒哈萨克自治县', null, '1');
INSERT INTO `t_pca` VALUES ('652700', '博尔塔拉蒙古自治州', null, '1');
INSERT INTO `t_pca` VALUES ('652701', '博乐市', null, '1');
INSERT INTO `t_pca` VALUES ('652702', '阿拉山口市', null, '1');
INSERT INTO `t_pca` VALUES ('652722', '精河县', null, '1');
INSERT INTO `t_pca` VALUES ('652723', '温泉县', null, '1');
INSERT INTO `t_pca` VALUES ('652800', '巴音郭楞蒙古自治州', null, '1');
INSERT INTO `t_pca` VALUES ('652801', '库尔勒市', null, '1');
INSERT INTO `t_pca` VALUES ('652822', '轮台县', null, '1');
INSERT INTO `t_pca` VALUES ('652823', '尉犁县', null, '1');
INSERT INTO `t_pca` VALUES ('652824', '若羌县', null, '1');
INSERT INTO `t_pca` VALUES ('652825', '且末县', null, '1');
INSERT INTO `t_pca` VALUES ('652826', '焉耆回族自治县', null, '1');
INSERT INTO `t_pca` VALUES ('652827', '和静县', null, '1');
INSERT INTO `t_pca` VALUES ('652828', '和硕县', null, '1');
INSERT INTO `t_pca` VALUES ('652829', '博湖县', null, '1');
INSERT INTO `t_pca` VALUES ('652900', '阿克苏地区', null, '1');
INSERT INTO `t_pca` VALUES ('652901', '阿克苏市', null, '1');
INSERT INTO `t_pca` VALUES ('652922', '温宿县', null, '1');
INSERT INTO `t_pca` VALUES ('652923', '库车县', null, '1');
INSERT INTO `t_pca` VALUES ('652924', '沙雅县', null, '1');
INSERT INTO `t_pca` VALUES ('652925', '新和县', null, '1');
INSERT INTO `t_pca` VALUES ('652926', '拜城县', null, '1');
INSERT INTO `t_pca` VALUES ('652927', '乌什县', null, '1');
INSERT INTO `t_pca` VALUES ('652928', '阿瓦提县', null, '1');
INSERT INTO `t_pca` VALUES ('652929', '柯坪县', null, '1');
INSERT INTO `t_pca` VALUES ('653000', '克孜勒苏柯尔克孜自治州', null, '1');
INSERT INTO `t_pca` VALUES ('653001', '阿图什市', null, '1');
INSERT INTO `t_pca` VALUES ('653022', '阿克陶县', null, '1');
INSERT INTO `t_pca` VALUES ('653023', '阿合奇县', null, '1');
INSERT INTO `t_pca` VALUES ('653024', '乌恰县', null, '1');
INSERT INTO `t_pca` VALUES ('653100', '喀什地区', null, '1');
INSERT INTO `t_pca` VALUES ('653101', '喀什市', null, '1');
INSERT INTO `t_pca` VALUES ('653121', '疏附县', null, '1');
INSERT INTO `t_pca` VALUES ('653122', '疏勒县', null, '1');
INSERT INTO `t_pca` VALUES ('653123', '英吉沙县', null, '1');
INSERT INTO `t_pca` VALUES ('653124', '泽普县', null, '1');
INSERT INTO `t_pca` VALUES ('653125', '莎车县', null, '1');
INSERT INTO `t_pca` VALUES ('653126', '叶城县', null, '1');
INSERT INTO `t_pca` VALUES ('653127', '麦盖提县', null, '1');
INSERT INTO `t_pca` VALUES ('653128', '岳普湖县', null, '1');
INSERT INTO `t_pca` VALUES ('653129', '伽师县', null, '1');
INSERT INTO `t_pca` VALUES ('653130', '巴楚县', null, '1');
INSERT INTO `t_pca` VALUES ('653131', '塔什库尔干塔吉克自治县', null, '1');
INSERT INTO `t_pca` VALUES ('653200', '和田地区', null, '1');
INSERT INTO `t_pca` VALUES ('653201', '和田市', null, '1');
INSERT INTO `t_pca` VALUES ('653221', '和田县', null, '1');
INSERT INTO `t_pca` VALUES ('653222', '墨玉县', null, '1');
INSERT INTO `t_pca` VALUES ('653223', '皮山县', null, '1');
INSERT INTO `t_pca` VALUES ('653224', '洛浦县', null, '1');
INSERT INTO `t_pca` VALUES ('653225', '策勒县', null, '1');
INSERT INTO `t_pca` VALUES ('653226', '于田县', null, '1');
INSERT INTO `t_pca` VALUES ('653227', '民丰县', null, '1');
INSERT INTO `t_pca` VALUES ('654000', '伊犁哈萨克自治州', null, '1');
INSERT INTO `t_pca` VALUES ('654002', '伊宁市', null, '1');
INSERT INTO `t_pca` VALUES ('654003', '奎屯市', null, '1');
INSERT INTO `t_pca` VALUES ('654004', '霍尔果斯市', null, '1');
INSERT INTO `t_pca` VALUES ('654021', '伊宁县', null, '1');
INSERT INTO `t_pca` VALUES ('654022', '察布查尔锡伯自治县', null, '1');
INSERT INTO `t_pca` VALUES ('654023', '霍城县', null, '1');
INSERT INTO `t_pca` VALUES ('654024', '巩留县', null, '1');
INSERT INTO `t_pca` VALUES ('654025', '新源县', null, '1');
INSERT INTO `t_pca` VALUES ('654026', '昭苏县', null, '1');
INSERT INTO `t_pca` VALUES ('654027', '特克斯县', null, '1');
INSERT INTO `t_pca` VALUES ('654028', '尼勒克县', null, '1');
INSERT INTO `t_pca` VALUES ('654200', '塔城地区', null, '1');
INSERT INTO `t_pca` VALUES ('654201', '塔城市', null, '1');
INSERT INTO `t_pca` VALUES ('654202', '乌苏市', null, '1');
INSERT INTO `t_pca` VALUES ('654221', '额敏县', null, '1');
INSERT INTO `t_pca` VALUES ('654223', '沙湾县', null, '1');
INSERT INTO `t_pca` VALUES ('654224', '托里县', null, '1');
INSERT INTO `t_pca` VALUES ('654225', '裕民县', null, '1');
INSERT INTO `t_pca` VALUES ('654226', '和布克赛尔蒙古自治县', null, '1');
INSERT INTO `t_pca` VALUES ('654300', '阿勒泰地区', null, '1');
INSERT INTO `t_pca` VALUES ('654301', '阿勒泰市', null, '1');
INSERT INTO `t_pca` VALUES ('654321', '布尔津县', null, '1');
INSERT INTO `t_pca` VALUES ('654322', '富蕴县', null, '1');
INSERT INTO `t_pca` VALUES ('654323', '福海县', null, '1');
INSERT INTO `t_pca` VALUES ('654324', '哈巴河县', null, '1');
INSERT INTO `t_pca` VALUES ('654325', '青河县', null, '1');
INSERT INTO `t_pca` VALUES ('654326', '吉木乃县', null, '1');
INSERT INTO `t_pca` VALUES ('659001', '石河子市', null, '1');
INSERT INTO `t_pca` VALUES ('659002', '阿拉尔市', null, '1');
INSERT INTO `t_pca` VALUES ('659003', '图木舒克市', null, '1');
INSERT INTO `t_pca` VALUES ('659004', '五家渠市', null, '1');
INSERT INTO `t_pca` VALUES ('659005', '北屯市', null, '1');
INSERT INTO `t_pca` VALUES ('659006', '铁门关市', null, '1');
INSERT INTO `t_pca` VALUES ('659007', '双河市', null, '1');
INSERT INTO `t_pca` VALUES ('659008', '可克达拉市', null, '1');
INSERT INTO `t_pca` VALUES ('659009', '昆玉市', null, '1');
INSERT INTO `t_pca` VALUES ('710000', '台湾省', null, '1');
INSERT INTO `t_pca` VALUES ('810000', '香港特别行政区', null, '1');
INSERT INTO `t_pca` VALUES ('820000', '澳门特别行政区', null, '1');

-- ----------------------------
-- Table structure for t_position
-- ----------------------------
DROP TABLE IF EXISTS `t_position`;
CREATE TABLE `t_position` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '岗位id',
  `name` varchar(200) DEFAULT NULL COMMENT '岗位名称',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态1=有效，0=无效',
  `description` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(100) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(100) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='岗位表';

-- ----------------------------
-- Records of t_position
-- ----------------------------

-- ----------------------------
-- Table structure for t_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_resource`;
CREATE TABLE `t_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资源id',
  `code` varchar(100) DEFAULT NULL COMMENT '资源代码',
  `type` varchar(100) DEFAULT NULL COMMENT '资源类型',
  `name` varchar(200) DEFAULT NULL COMMENT '资源名称',
  `url` varchar(200) DEFAULT NULL COMMENT '地址',
  `method` varchar(20) DEFAULT NULL COMMENT '方法',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态1=有效，0=无效',
  `description` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(100) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(100) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_resources_code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='资源表';

-- ----------------------------
-- Records of t_resource
-- ----------------------------

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `code` varchar(100) NOT NULL COMMENT '角色编码',
  `name` varchar(200) DEFAULT NULL COMMENT '角色名称',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态1=有效，0=无效',
  `description` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(100) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(100) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_role_code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色表';

-- ----------------------------
-- Records of t_role
-- ----------------------------

-- ----------------------------
-- Table structure for t_role_menu_ref
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu_ref`;
CREATE TABLE `t_role_menu_ref` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色菜单id',
  `menu_id` int(11) NOT NULL COMMENT '菜单id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态1=有效，0=无效',
  `description` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(100) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(100) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`),
  KEY `idx_menu_id_2` (`menu_id`),
  KEY `idx_role_id_3` (`role_id`),
  CONSTRAINT `FK_menu_role_ref` FOREIGN KEY (`menu_id`) REFERENCES `t_menu` (`id`),
  CONSTRAINT `FK_role_menu_ref` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色和菜单关系表';

-- ----------------------------
-- Records of t_role_menu_ref
-- ----------------------------

-- ----------------------------
-- Table structure for t_role_resource_ref
-- ----------------------------
DROP TABLE IF EXISTS `t_role_resource_ref`;
CREATE TABLE `t_role_resource_ref` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色资源id',
  `resource_id` int(11) NOT NULL COMMENT '资源id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `is_enable` varchar(1) DEFAULT NULL COMMENT '是否可用',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态1=有效，0=无效',
  `description` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(100) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(100) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`),
  KEY `idx_resource_id_2` (`resource_id`),
  KEY `idx_role_id_2` (`role_id`),
  CONSTRAINT `FK_resource_role_ref` FOREIGN KEY (`resource_id`) REFERENCES `t_resource` (`id`),
  CONSTRAINT `FK_role_resource_ref` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色和资源关系表';

-- ----------------------------
-- Records of t_role_resource_ref
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_code` varchar(100) DEFAULT NULL COMMENT '用户代码',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名称',
  `user_type` varchar(15) DEFAULT NULL COMMENT '用户类型',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `sex` varchar(2) DEFAULT NULL COMMENT '性别',
  `date_birth` datetime DEFAULT NULL COMMENT '出生日期',
  `birthplace` varchar(50) DEFAULT NULL COMMENT '籍贯',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `email` varchar(50) DEFAULT NULL COMMENT 'email',
  `id_number` varchar(30) DEFAULT NULL COMMENT '证件号码',
  `id_number_type` varchar(10) DEFAULT NULL COMMENT '证件类型',
  `me_level` varchar(15) DEFAULT NULL COMMENT '本人级别',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `account_expired` tinyint(1) DEFAULT NULL COMMENT '账号是否未过期',
  `credentials_non_expired` tinyint(1) DEFAULT NULL COMMENT '密码是否未过期',
  `account_non_locked` tinyint(1) DEFAULT NULL COMMENT '账号锁定',
  `boss` varchar(50) DEFAULT NULL COMMENT '上级人',
  `boss_level` varchar(15) DEFAULT NULL COMMENT '上级人级别',
  `boss_phone` varchar(20) DEFAULT NULL COMMENT '上级联系电话',
  `boss_mobile` varchar(20) DEFAULT NULL COMMENT '上级手机',
  `expiration_date` datetime DEFAULT NULL COMMENT '过期日期',
  `password_question` varchar(20) DEFAULT NULL COMMENT '密码问题',
  `password_answer` varchar(20) DEFAULT NULL COMMENT '密码答案',
  `last_login` datetime DEFAULT NULL COMMENT '最后登录时间',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态1=有效，0=无效',
  `description` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(100) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(100) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_code` (`user_code`),
  KEY `idx_user_name` (`user_name`),
  KEY `idx_address_id2` (`address`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户基本资料表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', null, 'chen4', null, '1111', null, null, null, null, '1350009983434', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_user` VALUES ('2', null, 'chen42', null, '1111', null, null, null, null, '1350009983434', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_user` VALUES ('3', null, 'c', null, '1111', null, null, null, null, '1350009983434', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_user` VALUES ('4', null, 'dc', null, '1111', null, null, null, null, '1350009983434', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_user` VALUES ('5', null, 'dc2', null, '1111', null, null, null, null, '1350009983434', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_user` VALUES ('6', null, '112', null, '1111', null, null, null, null, '1350009983439', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null);
INSERT INTO `t_user` VALUES ('7', null, '112', null, '1111', null, null, null, null, '1350009983439', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null);

-- ----------------------------
-- Table structure for t_user_group_ref
-- ----------------------------
DROP TABLE IF EXISTS `t_user_group_ref`;
CREATE TABLE `t_user_group_ref` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户组id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `group_id` int(11) NOT NULL COMMENT '用户组id',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态1=有效，0=无效',
  `description` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(100) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(100) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`),
  KEY `FK_group_user_ref` (`group_id`),
  KEY `FK_user_group_ref` (`user_id`),
  CONSTRAINT `FK_group_user_ref` FOREIGN KEY (`group_id`) REFERENCES `t_group` (`id`),
  CONSTRAINT `FK_user_group_ref` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户和组关系表';

-- ----------------------------
-- Records of t_user_group_ref
-- ----------------------------

-- ----------------------------
-- Table structure for t_user_log
-- ----------------------------
DROP TABLE IF EXISTS `t_user_log`;
CREATE TABLE `t_user_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `login_time` datetime DEFAULT NULL COMMENT '登陆时间',
  `login_ip` varchar(20) DEFAULT NULL COMMENT '登陆ip',
  `function_code` varchar(50) DEFAULT NULL COMMENT '功能模块代码',
  `log_desc` varchar(50) DEFAULT NULL COMMENT '活动日志',
  `description` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(100) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`),
  KEY `idx_user_id_2` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户日志';

-- ----------------------------
-- Records of t_user_log
-- ----------------------------

-- ----------------------------
-- Table structure for t_user_position_ref
-- ----------------------------
DROP TABLE IF EXISTS `t_user_position_ref`;
CREATE TABLE `t_user_position_ref` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户岗位id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `position_id` int(11) NOT NULL COMMENT '关系id',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态1=有效，0=无效',
  `description` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(100) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(100) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`),
  KEY `FK_position_user_ref` (`position_id`),
  KEY `FK_user_position_ref` (`user_id`),
  CONSTRAINT `FK_position_user_ref` FOREIGN KEY (`position_id`) REFERENCES `t_position` (`id`),
  CONSTRAINT `FK_user_position_ref` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户和角色系表';

-- ----------------------------
-- Records of t_user_position_ref
-- ----------------------------

-- ----------------------------
-- Table structure for t_user_role_ref
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role_ref`;
CREATE TABLE `t_user_role_ref` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态1=有效，0=无效',
  `description` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(100) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(100) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`),
  KEY `idx_user_id_1` (`user_id`),
  KEY `idx_role_id_1` (`role_id`),
  CONSTRAINT `FK_role_user_ref` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`),
  CONSTRAINT `FK_user_role_ref` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户和角色关系表';

-- ----------------------------
-- Records of t_user_role_ref
-- ----------------------------
