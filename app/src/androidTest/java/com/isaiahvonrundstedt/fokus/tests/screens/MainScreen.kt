package com.isaiahvonrundstedt.fokus.screens



import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.toolbar.KToolbar
import com.isaiahvonrundstedt.fokus.R
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView



object MainScreen: KScreen<MainScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val toolBar = KToolbar {withId(R.id.toolbar)}
//    val toolBarBurgerButton = KButton{
//        withParent { this@MainScreen.toolBar }
//    }
    val toolBarMoreOptionsButton = KButton{
        withContentDescription("More options")
        withParent { this@MainScreen.toolBar }
    }
    val toolBarText = KTextView{
        withText("Your Tasks")
        withParent { this@MainScreen.toolBar }
    }
    val noTaskText = KTextView {withText("No Pending Tasks")}
    val noTaskSubTitleText = KTextView { withText("You currently have no pending tasks. If you have one, add it using the button below.")}
    val saveButton = KButton { withId(R.id.actionButton) }


    fun buttonStatusCheckAndClick(button:KButton,needClick:Boolean = false){
        button.isDisplayed()
        button.isClickable()
        if(needClick) button.click()
    }

}