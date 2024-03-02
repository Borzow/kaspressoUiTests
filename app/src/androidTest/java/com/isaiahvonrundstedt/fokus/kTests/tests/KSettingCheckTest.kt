package com.isaiahvonrundstedt.fokus.kTests.tests

import androidx.test.ext.junit.rules.activityScenarioRule
import com.isaiahvonrundstedt.fokus.features.core.activities.MainActivity
import com.isaiahvonrundstedt.fokus.kTests.screens.MainScreen
import com.isaiahvonrundstedt.fokus.kTests.screens.NavigateScreen
import com.isaiahvonrundstedt.fokus.kTests.screens.SettingsScreen
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test

class KSettingCheckTest:TestCase() {

    @get:Rule
    val activeRule = activityScenarioRule<MainActivity>()

    @Test
    fun test(){
        before {

        }.after {

        }.run {
            step("""Предусловия"""){
                MainScreen{
                    noTaskText.isDisplayed()
                    noTaskSubTitleText.isDisplayed()
                }
            }
            step("""Нажимаем на Бургер меню в tool Bar"""){
                MainScreen{
                    buttonIsDisplayedAndClickable(toolBarBurgerButton,true)
                }
                step("""С левого края выезжает экран,с:
                        - Надписью "Good [время дня на устройстве]!"
                        - Кнопка "Tasks"
                        - Кнопка "Events"
                        - Кнопка "Subjects"
                        - Кнопка "Logs"
                        - Кнопка "Settings"
                        - Кнопка "About""""){
                    NavigateScreen{

                    }
                }
            }
            step("""Нажимаем на кнопку "Settings""""){
                NavigateScreen{

                }
                step("""Переходим на экран Settings, на экране:
                        - Надпись "Settings" в tool Bar
                        - Кнопка "Назад" ( <- ) в tool Bar
                        - Надпись "Interface"
                        - Кнопка "Theme" с описанием "System default"
                        - Тогл "Confetti" с описанием "Show confetti when tasks are marked as finished",
                        по умолчанию: Вкл
                        - Надпись "Sound"
                        - Тогл "Completion Sounds" с описанием "Play a sound when you mark a task as completed",
                        по умолчанию: Вкл
                        - Надпись "Notifications"
                        - Кнопка "Reminder frequency" с описанием "Everyday"
                        - Кнопка "Remind me at this time" с описанием "8:30 AM"
                        - Тогл "When a task is nearing due" с описанием "Show notifications for tasks that are nearing its deadline",
                        по умолчанию: Вкл
                        - Кнопка "Task reminder interval" с описанием "3 hours before""""){
                    SettingsScreen{
                        settingRecycler{
                            childAt<SettingsScreen.SettingItems>(1){

                            }
                        }
                    }
                }
            }
            step("""Прокручиваем экран до момента пропажи кнопким "Task reminder interval" и её описания"""){
                SettingsScreen{

                }
                step("""На экране отображаются:
                        - Надпись "Settings" в tool Bar
                        - Кнопка "Назад" ( <- ) в tool Bar
                        - Тогл "Incoming events" с описанием "Show notifications about incoming events this day",
                        по умолчанию: Вкл
                        - Кнопка "Event reminder interval" с описанием "30 minutes before"
                        - Тогл "Classes for this day" с описанием "Show notifications about classes for my subjects this day",
                        по умолчанию: Вкл
                        - Кнопка "Class reminder interval" с описанием "5 minutes before""""){
                    SettingsScreen{

                    }
                }
            }
            step("""Прокручиваем экран до конца:"""){
                SettingsScreen{

                }
                step("""а экране отображаются:
                        - Надпись "Settings" в tool Bar
                        - Кнопка "Назад" ( <- ) в tool Bar
                        - Надпись "More Settings"
                        - Надпись "Advanced"
                        - Тогл "Enable Week Numbers" с описанием "Show week numbers when configuring schedules.",
                        по умолчанию: Выкл
                        - Кнопка "Backup and Restore"
                        - Тогл "Open links in external browser" с описанием "Use the system default browser to handle hyperlinks",
                        по умолчанию: Выкл
                        - Надпись "Debugging"
                        - Описание "Sometimes, your notification might not trigger due to the aggressive battery optimization by your phone manufacturer."
                        - Кнопка "Learn More""""){
                    SettingsScreen{

                    }
                }
            }
        }
    }
}