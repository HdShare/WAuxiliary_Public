package wx.demo.hook.ver

import me.hd.wauxv.data.config.DescriptorData
import me.hd.wauxv.hook.anno.HookAnno
import me.hd.wauxv.hook.anno.ViewAnno
import me.hd.wauxv.hook.api.IDexFind
import me.hd.wauxv.hook.base.SwitchHook
import me.hd.wauxv.hook.factory.toDexMethod
import org.lsposed.lsparanoid.Obfuscate
import org.luckypray.dexkit.DexKitBridge

@Obfuscate
@HookAnno
@ViewAnno
object MsgTailHook : SwitchHook("AntiRevoke1Hook") {
    override val location = "增强"
    override val funcName = "消息尾巴"
    override val funcDesc = "消息尾巴"

    override fun initOnce() {
        "uk0.q1".toClass().apply {
            method {
                name = "e"
                paramCount= 1
            }.hook {
                before {
                    val str: String = args[0].toString()
                    args[0] = str + "喵~"
                }
            }
        }
    }
}
