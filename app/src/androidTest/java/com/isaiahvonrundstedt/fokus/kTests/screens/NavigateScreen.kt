package com.isaiahvonrundstedt.fokus.kTests.screens

import com.isaiahvonrundstedt.fokus.R
import com.isaiahvonrundstedt.fokus.kTests.FrequencyTestChecks
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView

object NavigateScreen : KScreen<NavigateScreen>(), FrequencyTestChecks {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val menuTitle = KTextView { withId(R.id.menuTitleView) }
    val itemTask = KButton {
        withId(R.id.navigation_tasks)
        withDescendant {
            withId(R.id.design_menu_item_text)
            withText("Tasks")
        }
    }
    val itemEvents = KButton {
        withId(R.id.navigation_events)
        withDescendant {
            withId(R.id.design_menu_item_text)
            withText("Events")
        }
    }
    val itemSubjects = KButton {
        withId(R.id.navigation_subjects)
        withDescendant {
            withId(R.id.design_menu_item_text)
            withText("Subjects")
        }
    }
    val itemLogs = KButton {
        withId(R.id.navigation_logs)
        withDescendant {
            withId(R.id.design_menu_item_text)
            withText("Logs")
        }
    }
    val itemSettings = KButton {
        withId(R.id.navigation_settings)
        withDescendant {
            withId(R.id.design_menu_item_text)
            withText("Settings")
        }
    }
    val itemAbout = KButton {
        withId(R.id.navigation_about)
        withDescendant {
            withId(R.id.design_menu_item_text)
            withText("About")
        }
    }
}