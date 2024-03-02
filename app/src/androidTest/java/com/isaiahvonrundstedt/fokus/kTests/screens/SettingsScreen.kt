package com.isaiahvonrundstedt.fokus.kTests.screens

import android.view.View
import com.isaiahvonrundstedt.fokus.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.toolbar.KToolbar
import org.hamcrest.Matcher


object SettingsScreen:KScreen<SettingsScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val toolBar = KToolbar {withId(R.id.toolbar)}
    val toolBarBurgerButton = KButton{
        withParent { this@SettingsScreen.toolBar }
        withContentDescription("More")
    }
    val toolBarMoreOptionsButton = KButton{
        withContentDescription("More options")
        withParent { this@SettingsScreen.toolBar }
    }
    val toolBarText = KTextView{
        withText("Settings")
        withParent { this@SettingsScreen.toolBar }
    }
    val settingRecycler = KRecyclerView(
        {withId(R.id.recycler_view)},
        {itemType ( :: SettingItems)}
    )

    class SettingItems(parent: Matcher<View>) :KRecyclerItem<SettingItems>(parent){
        val itemTitleText = KTextView(parent){withId(R.id.title)}
        val itemSubTitleText = KTextView(parent){withId(R.id.summaryView)}
        val itemImage = KImageView(parent){withId(R.id.icon)}
    }
}