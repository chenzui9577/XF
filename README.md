# XF

项目源代码、静态资源和部署配置，按本地项目目录结构整理。

- `xf-mq/`：消防平台消息队列项目，包含客户端、服务端和公共模块。
- `GetDB(token)/`：DBDemo 项目源代码和前端静态资源。
- `Client/`、`Server/`、`DBdemo/`：Windows 服务配置及附属资源。

## 本地配置

以下目录提供 `application.example.yml`。运行或打包前，将其复制为同目录下的 `application.yml`，再填写自己的数据库和 RabbitMQ 连接信息：

- `xf-mq/xf-client/src/main/resources/`
- `xf-mq/xf-server/src/main/resources/`
- `GetDB(token)/DBDemo/src/main/resources/`

真实连接配置、运行日志、IDE 缓存及 JAR/EXE 打包文件不纳入版本控制。本地原有文件保留；需要部署时请使用自己的配置重新构建，并自行准备 Windows 服务包装程序。

消息队列项目的说明见 [xf-mq/README.md](xf-mq/README.md)。
