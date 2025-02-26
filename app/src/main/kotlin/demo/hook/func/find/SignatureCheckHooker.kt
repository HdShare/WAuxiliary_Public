import...


object WeChatSignatureHooker : CommonSwitchHooker(), IDexFindBase {
    private object SignatureCheckMethod : DescData()

    override val funcName = "微信签名校验"
    override val funcDesc = "绕过微信分享时的签名校验检查"

    override fun initOnce() {
        DexMethod(SignatureCheckMethod.desc)
            .getMethodInstance(HostInfo.appClassLoader)
            .hook {
                afterIfEnabled {
                    result = true
                }
            }
    }

    override fun dexFind(initiate: DexKitBridge) {
        SignatureCheckMethod.desc = initiate.findMethod {
            matcher {
                paramTypes = listOf(
                    "android.content.Context",
                    "com.tencent.mm.pluginsdk.model.app.m",
                    "java.lang.String",
                    "com.tencent.mm.pluginsdk.model.app.d4",
                    "com.tencent.mm.pluginsdk.model.app.b4",
                    "boolean"
                )
                returnType = "boolean"
                name = "b"
                declaringClass = "com.tencent.mm.pluginsdk.model.app.h1"
            }
        }.single().toDexMethod().toString()
    }
}
