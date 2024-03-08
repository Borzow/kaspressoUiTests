package com.isaiahvonrundstedt.fokus.kTests.tests

import androidx.test.ext.junit.rules.activityScenarioRule
import com.isaiahvonrundstedt.fokus.features.core.activities.MainActivity
import com.isaiahvonrundstedt.fokus.kTests.screens.MainScreen
import com.isaiahvonrundstedt.fokus.kTests.screens.NavigateScreen
import com.isaiahvonrundstedt.fokus.kTests.screens.SettingsScreen
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test

class KSettingCheckTest : TestCase() {

    @get:Rule
    val activeRule = activityScenarioRule<MainActivity>()

    @Test
    fun test() {
        before {

        }.after {

        }.run {
            step("""Предусловия""") {
                MainScreen {
                    noTaskText.isDisplayed()
                    noTaskSubTitleText.isDisplayed()
                }
            }
            step("""Нажимаем на Бургер меню в tool Bar""") {
                MainScreen {
                    buttonIsDisplayedAndClickable(toolBarBurgerButton, true)
                }
                step(
                    """С левого края выезжает экран,с:
                        - Надписью "Good [время дня на устройстве]!"
                        - Кнопка "Tasks"
                        - Кнопка "Events"
                        - Кнопка "Subjects"
                        - Кнопка "Logs"
                        - Кнопка "Settings"
                        - Кнопка "About""""
                ) {
                    NavigateScreen {
                        menuTitle.containsText("Good")
                        buttonIsDisplayedAndClickable(itemTask)
                        buttonIsDisplayedAndClickable(itemEvents)
                        buttonIsDisplayedAndClickable(itemSubjects)
                        buttonIsDisplayedAndClickable(itemLogs)
                        buttonIsDisplayedAndClickable(itemSettings)
                        buttonIsDisplayedAndClickable(itemAbout)
                    }
                }
            }
            step("""Нажимаем на кнопку "Settings"""") {
                NavigateScreen {
                    buttonIsDisplayedAndClickable(itemSettings, true)
                }
                step(
                    """Переходим на экран Settings, на экране:
                        - Надпись "Settings" в tool Bar
                        - Кнопка "Назад" ( <- ) в tool Bar """
                ) {
                    SettingsScreen {
                        toolBar.hasTitle("Settings")
                        buttonIsDisplayedAndClickable(backButton)
                    }
                }
            }
        }
    }
}