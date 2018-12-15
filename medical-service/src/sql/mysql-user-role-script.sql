-- CREATE DATABASE `spring_cloud` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
-- use spring_cloud;

SET FOREIGN_KEY_CHECKS=0;


DROP TABLE IF EXISTS oauth_access_token;
CREATE TABLE oauth_access_token
(
  token_id          VARCHAR(256) COMMENT 'MD5加密的access_token的值',
  token             blob COMMENT 'OAuth2AccessToken.java对象序列化后的二进制数据',
  authentication_id VARCHAR(256) COMMENT 'MD5加密过的username,client_id,scope',
  user_name         VARCHAR(256) COMMENT '登录的用户名',
  client_id         VARCHAR(256) COMMENT '客户端ID',
  authentication    blob COMMENT 'OAuth2Authentication.java对象序列化后的二进制数据',
  refresh_token     VARCHAR(256) COMMENT 'MD5加密果的refresh_token的值'
) COMMENT='访问令牌表';

DROP TABLE IF EXISTS oauth_refresh_token;
CREATE TABLE oauth_refresh_token
(
  token_id       VARCHAR(256) COMMENT 'MD5加密过的refresh_token的值',
  token          blob COMMENT 'OAuth2RefreshToken.java对象序列化后的二进制数据',
  authentication blob COMMENT 'OAuth2Authentication.java对象序列化后的二进制数据'
) COMMENT='refresh_token存储表';

DROP TABLE IF EXISTS oauth_approvals;
CREATE TABLE oauth_approvals
(
  userid         VARCHAR(256) COMMENT 'blob登录的用户名',
  clientid       VARCHAR(256) COMMENT '客户端ID',
  scope          VARCHAR(256) COMMENT '申请的权限',
  status         VARCHAR(10) COMMENT '状态（Approve或Deny）',
  expiresat      datetime COMMENT '过期时间',
  lastmodifiedat datetime  COMMENT '最终修改时间'
) COMMENT='授权记录表';

DROP TABLE IF EXISTS oauth_code;
CREATE TABLE oauth_code
(
  code           VARCHAR(256)  COMMENT '授权码(未加密)',
  authentication blob  COMMENT 'AuthorizationRequestHolder.java对象序列化后的二进制数据'
) COMMENT='授权码表';

DROP TABLE IF EXISTS oauth_client_details;
CREATE TABLE oauth_client_details
(
  client_id               VARCHAR(256) NOT NULL COMMENT '客户端ID',
  resource_ids            VARCHAR(256) COMMENT '资源ID集合,多个资源时用逗号(,)分隔',
  client_secret           VARCHAR(256) COMMENT '客户端密匙',
  scope                   VARCHAR(256) COMMENT '客户端申请的权限范围',
  authorized_grant_types  VARCHAR(256) COMMENT '客户端支持的grant_type',
  web_server_redirect_uri VARCHAR(256) COMMENT '重定向URI',
  authorities             VARCHAR(256) COMMENT '客户端所拥有的Spring Security的权限值，多个用逗号(,)分隔',
  access_token_validity   INTEGER COMMENT '访问令牌有效时间值(单位:秒)',
  refresh_token_validity  INTEGER COMMENT '更新令牌有效时间值(单位:秒)',
  additional_information  VARCHAR(4096) COMMENT '预留字段',
  autoapprove             VARCHAR(256) COMMENT '用户是否自动Approval操作',
  CONSTRAINT pk_oauth_client_details_client_id PRIMARY KEY (client_id)
) COMMENT='client用户表';

DROP TABLE IF EXISTS oauth_client_token;
CREATE TABLE oauth_client_token
(
  token_id          VARCHAR(256) COMMENT 'MD5加密的access_token值',
  token             blob COMMENT 'OAuth2AccessToken.java对象序列化后的二进制数据',
  authentication_id VARCHAR(256) COMMENT 'MD5加密过的username,client_id,scope',
  user_name         VARCHAR(256) COMMENT '登录的用户名',
  client_id         VARCHAR(256) COMMENT '客户端ID'
) COMMENT='客户端授权令牌表';

-- ----------------------
DROP TABLE IF EXISTS users;
CREATE TABLE users
(
  id                      INT NOT NULL AUTO_INCREMENT PRIMARY KEY  COMMENT '用户id',
  username                VARCHAR(100) NOT NULL COMMENT '用户名',
  password                VARCHAR(100) NOT NULL COMMENT '用户密码密文',
  name                    VARCHAR(200) COMMENT '用户姓名',
  mobile                  VARCHAR(20) COMMENT '用户手机',
  enabled                 bool COMMENT '是否有效用户',
  account_non_expired     BOOLEAN COMMENT '账号是否未过期',
  credentials_non_expired BOOLEAN COMMENT '密码是否未过期',
  account_non_locked      BOOLEAN ,
  created_time            datetime    NOT NULL DEFAULT now() COMMENT '创建时间',
  updated_time            datetime    NOT NULL DEFAULT now() COMMENT '更新时间',
  created_by              VARCHAR(100) NOT NULL COMMENT '创建人',
  updated_by              VARCHAR(100) NOT NULL COMMENT '更新人'
) COMMENT='用户表';


DROP TABLE IF EXISTS groups;
CREATE TABLE groups
(
  id           INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '用户组id',
  parent_id    INT          NOT NULL COMMENT '用户组父id',
  name         VARCHAR(200) COMMENT '用户组名称',
  description   VARCHAR(500)COMMENT '用户组简介',
  created_time datetime    NOT NULL DEFAULT now() COMMENT '创建时间',
  updated_time datetime    NOT NULL DEFAULT now() COMMENT '更新时间',
  created_by   VARCHAR(100) NOT NULL COMMENT '创建人',
  updated_by   VARCHAR(100) NOT NULL COMMENT '更新人'
) COMMENT='用户组表';

DROP TABLE IF EXISTS users_groups_relation;
CREATE TABLE users_groups_relation
(
  id           INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id      INT          NOT NULL COMMENT '用户id',
  group_id     INT          NOT NULL COMMENT '用户组id',
  created_time datetime    NOT NULL DEFAULT now() COMMENT '创建时间',
  updated_time datetime    NOT NULL DEFAULT now() COMMENT '更新时间',
  created_by   VARCHAR(100) NOT NULL COMMENT '创建人',
  updated_by   VARCHAR(100) NOT NULL COMMENT '更新人'
) COMMENT='用户和组关系表';

DROP TABLE IF EXISTS positions;
CREATE TABLE positions
(
  id           INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '岗位id',
  name         VARCHAR(200) COMMENT '岗位名称',
  description   VARCHAR(500) COMMENT '岗位简介',
  created_time datetime    NOT NULL DEFAULT now() COMMENT '创建时间',
  updated_time datetime    NOT NULL DEFAULT now() COMMENT '更新时间',
  created_by   VARCHAR(100) NOT NULL COMMENT '创建人',
  updated_by   VARCHAR(100) NOT NULL COMMENT '更新人'
) COMMENT='岗位表';

DROP TABLE IF EXISTS users_positions_relation;
CREATE TABLE users_positions_relation
(
  id           INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id      INT          NOT NULL COMMENT '用户id',
  position_id  INT          NOT NULL COMMENT '关系id',
  created_time datetime    NOT NULL DEFAULT now() COMMENT '创建时间',
  updated_time datetime    NOT NULL DEFAULT now() COMMENT '更新时间',
  created_by   VARCHAR(100) NOT NULL COMMENT '创建人',
  updated_by   VARCHAR(100) NOT NULL COMMENT '更新人'
) COMMENT='用户和角色系表';

DROP TABLE IF EXISTS roles;
CREATE TABLE roles
(
  id           INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  code         VARCHAR(100) NOT NULL COMMENT '角色编码',
  name         VARCHAR(200) COMMENT '角色名称',
  description   VARCHAR(500) COMMENT '角色简介',
  created_time datetime    NOT NULL DEFAULT now() COMMENT '创建时间',
  updated_time datetime    NOT NULL DEFAULT now() COMMENT '更新时间',
  created_by   VARCHAR(100) NOT NULL COMMENT '创建人',
  updated_by   VARCHAR(100) NOT NULL COMMENT '更新人'
) COMMENT='角色表';

DROP TABLE IF EXISTS users_roles_relation;
CREATE TABLE users_roles_relation
(
  id           INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id      INT          NOT NULL,
  role_id      INT          NOT NULL,
  created_time datetime    NOT NULL DEFAULT now() COMMENT '创建时间',
  updated_time datetime    NOT NULL DEFAULT now() COMMENT '更新时间',
  created_by   VARCHAR(100) NOT NULL COMMENT '创建人',
  updated_by   VARCHAR(100) NOT NULL COMMENT '更新人'
) COMMENT='用户和角色关系表';

DROP TABLE IF EXISTS menus;
CREATE TABLE menus
(
  id           INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  parent_id    INT          NOT NULL COMMENT '父菜单id',
  type         VARCHAR(100) COMMENT '菜单类型',
  href         VARCHAR(200) COMMENT '菜单路径',
  icon         VARCHAR(200) COMMENT '菜单图标',
  name         VARCHAR(200) COMMENT '菜单名称',
  description   VARCHAR(500) COMMENT '菜单简介',
  order_num    INTEGER COMMENT '订单数',
  created_time datetime    NOT NULL DEFAULT now() COMMENT '创建时间',
  updated_time datetime    NOT NULL DEFAULT now() COMMENT '更新时间',
  created_by   VARCHAR(100) NOT NULL COMMENT '创建人',
  updated_by   VARCHAR(100) NOT NULL COMMENT '更新人'
) COMMENT='菜单表';


DROP TABLE IF EXISTS roles_menus_relation;
CREATE TABLE roles_menus_relation
(
  id           INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  menu_id      INT          NOT NULL,
  role_id      INT          NOT NULL,
  created_time datetime    NOT NULL DEFAULT now() COMMENT '创建时间',
  updated_time datetime    NOT NULL DEFAULT now() COMMENT '更新时间',
  created_by   VARCHAR(100) NOT NULL COMMENT '创建人',
  updated_by   VARCHAR(100) NOT NULL COMMENT '更新人'
) COMMENT='角色和菜单关系表';

DROP TABLE IF EXISTS resources;
CREATE TABLE resources
(
  id           INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  code         VARCHAR(100),
  type         VARCHAR(100),
  name         VARCHAR(200),
  url          VARCHAR(200),
  method       VARCHAR(20),
  description  VARCHAR(500),
  created_time datetime    NOT NULL DEFAULT now() COMMENT '创建时间',
  updated_time datetime    NOT NULL DEFAULT now() COMMENT '更新时间',
  created_by   VARCHAR(100) NOT NULL COMMENT '创建人',
  updated_by   VARCHAR(100) NOT NULL COMMENT '更新人'
) COMMENT='资源表';

CREATE UNIQUE INDEX ux_resources_code ON resources (code);

DROP TABLE IF EXISTS roles_resources_relation;
CREATE TABLE roles_resources_relation
(
  id           INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  resource_id  INT          NOT NULL,
  role_id      INT          NOT NULL,
  created_time datetime    NOT NULL DEFAULT now() COMMENT '创建时间',
  updated_time datetime    NOT NULL DEFAULT now() COMMENT '更新时间',
  created_by   VARCHAR(100) NOT NULL COMMENT '创建人',
  updated_by   VARCHAR(100) NOT NULL COMMENT '更新人'
) COMMENT='角色和资源关系表';


INSERT INTO oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove)
VALUES ('test_client', NULL, '$2a$10$2szDKjvKHJCWE6YQNznogOeQF3USZHmCYj1fG7YbfK.vnTgNKLzri', 'read', 'password,refresh_token', NULL, NULL, NULL, NULL, NULL, NULL);

INSERT INTO users (id, username, password, enabled, account_non_expired, credentials_non_expired, account_non_locked, name, mobile, created_time, updated_time, created_by, updated_by)
VALUES
  (101, 'admin', '$2a$10$vYA9wKn/hVGOtwQw2eHiceeIGNBdfLYpDmbzHgBSVmOfHXPH4iYdS', 1, 1, 1, 1,
        '超级管理员', '', now(), now(), 'system', 'system'),
  (102, 'zhoutaoo', '$2a$10$vYA9wKn/hVGOtwQw2eHiceeIGNBdfLYpDmbzHgBSVmOfHXPH4iYdS', 1, 1, 1, 1,
        '周涛', 15619841000, now(), now(), 'system', 'system');

INSERT INTO positions (id, name, description, created_time, updated_time, created_by, updated_by)
VALUES (101, '首席执行官', '公司CEO，负责公司整体运转', now(), now(), 'system', 'system'),
  (102, '首席运营官', '公司COO，负责公司整体运营', now(), now(), 'system', 'system'),
  (103, '首席技术官', '公司CTO，负责公司整体运营', now(), now(), 'system', 'system');

INSERT INTO roles (id, code, name, description, created_time, updated_time, created_by, updated_by)
VALUES (101, 'ADMIN', '超级管理员', '公司IT总负责人', now(), now(), 'system', 'system'),
  (102, 'FIN', '财务', '财务', now(), now(), 'system', 'system'),
  (103, 'IT', 'IT', 'IT角色', now(), now(), 'system', 'system');

INSERT INTO groups (id, parent_id, name, description, created_time, updated_time, created_by, updated_by)
VALUES (101, -1, '总公司', '总公司', now(), now(), 'system', 'system'),
  (102, 101, '上海分公司', '上海分公司', now(), now(), 'system', 'system'),
  (103, 102, '研发部门', '负责产品研发', now(), now(), 'system', 'system'),
  (104, 102, '产品部门', '负责产品设计', now(), now(), 'system', 'system'),
  (105, 102, '运营部门', '负责公司产品运营', now(), now(), 'system', 'system'),
  (106, 102, '销售部门', '负责公司产品销售', now(), now(), 'system', 'system'),
  (107, 101, '北京分公司', '北京分公司', now(), now(), 'system', 'system');

INSERT INTO menus (id, parent_id, type, href, icon, name, description, order_num, created_time, updated_time, created_by, updated_by)
VALUES (101, -1, 'MENU', '/admin', 'setting', '系统管理', '系统设置管理', 0, now(), now(), 'system', 'system'),
  (102, 101, 'MENU', '/admin/users', 'fa-user', '用户管理', '用户新增，修改，查看，删除', 10, now(), now(), 'system', 'system'),
  (103, 101, 'MENU', '/admin/menus', 'category', '菜单管理', '菜单新增，修改，删除', 20, now(), now(), 'system', 'system');

INSERT INTO resources (id, name, code, type, url, method, description, created_time, updated_time, created_by, updated_by)
VALUES (101, '新增', 'user_manager:btn_add', 'button', '/users', 'POST', '新增用户功能', now(), now(), 'system', 'system'),
  (102, '编辑', 'user_manager:btn_edit', 'button', '/users', 'PUT', '编辑用户功能', now(), now(), 'system', 'system'),
  (103, '删除', 'user_manager:btn_del', 'button', '/users/{id}', 'DELETE', '删除用户功能', now(), now(), 'system', 'system'),
  (104, '查看', 'user_manager:view', 'url', '/users/{id}', 'GET', '查询用户功能', now(), now(), 'system', 'system');


INSERT INTO users_roles_relation (id, user_id, role_id, created_time, updated_time, created_by, updated_by)
VALUES (101, 101, 101, now(), now(), 'system', 'system'),
  (102, 102, 101, now(), now(), 'system', 'system'),
  (103, 102, 103, now(), now(), 'system', 'system');
INSERT INTO users_groups_relation (id, user_id, group_id, created_time, updated_time, created_by, updated_by)
VALUES (101, 101, 101, now(), now(), 'system', 'system'),
  (102, 102, 101, now(), now(), 'system', 'system');
INSERT INTO users_positions_relation (id, user_id, position_id, created_time, updated_time, created_by, updated_by)
VALUES (101, 101, 103, now(), now(), 'system', 'system'),
  (102, 102, 103, now(), now(), 'system', 'system');

INSERT INTO roles_menus_relation (id, role_id, menu_id, created_time, updated_time, created_by, updated_by)
VALUES (101, 101, 101, now(), now(), 'system', 'system'),
  (102, 101, 102, now(), now(), 'system', 'system'),
  (103, 101, 103, now(), now(), 'system', 'system'),
  (104, 102, 101, now(), now(), 'system', 'system'),
  (105, 102, 102, now(), now(), 'system', 'system'),
  (106, 103, 101, now(), now(), 'system', 'system'),
  (107, 103, 102, now(), now(), 'system', 'system'),
  (108, 103, 103, now(), now(), 'system', 'system');
INSERT INTO roles_resources_relation (id, role_id, resource_id, created_time, updated_time, created_by, updated_by)
VALUES (101, 101, 101, now(), now(), 'system', 'system'),
  (102, 101, 102, now(), now(), 'system', 'system'),
  (103, 101, 103, now(), now(), 'system', 'system'),
  (104, 101, 104, now(), now(), 'system', 'system'),
  (105, 102, 104, now(), now(), 'system', 'system'),
  (106, 103, 101, now(), now(), 'system', 'system'),
  (107, 103, 102, now(), now(), 'system', 'system'),
  (108, 103, 103, now(), now(), 'system', 'system'),
  (109, 103, 104, now(), now(), 'system', 'system');