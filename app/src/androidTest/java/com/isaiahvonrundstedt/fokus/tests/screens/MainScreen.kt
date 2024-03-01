package com.isaiahvonrundstedt.fokus.screens



import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.toolbar.KToolbar
import com.isaiahvonrundstedt.fokus.R
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher


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

    val taskRecycler = KRecyclerView(
        { withId(R.id.recyclerView) },
        { itemType(::TaskItems) }
    )

    fun buttonStatusCheckAndClick(button:KButton,needClick:Boolean = false){
        button.isDisplayed()
        button.isClickable()
        if(needClick) button.click()
    }
    class TaskItems(parent: Matcher<View>) :KRecyclerItem<TaskItems>(parent){
        val testCheckBox = KCheckBox(parent){withId(R.id.checkBox)}
        val taskName = KTextView(parent){withId(R.id.taskNameView)}
        val taskEndDate = KTextView(parent){withId(R.id.dueDateView)}
        val taskSubject = KTextView(parent){withId(R.id.subjectView)}
    }
}