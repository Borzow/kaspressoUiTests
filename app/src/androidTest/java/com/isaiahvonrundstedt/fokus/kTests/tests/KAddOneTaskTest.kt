package com.isaiahvonrundstedt.fokus.kTests.tests

import androidx.test.ext.junit.rules.activityScenarioRule
import com.isaiahvonrundstedt.fokus.features.core.activities.MainActivity
import com.isaiahvonrundstedt.fokus.kTests.screens.MainScreen
import com.isaiahvonrundstedt.fokus.kTests.screens.TaskScreen
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test

class KAddOneTaskTest:TestCase (){

    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

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
            step("""Нажимаем на кнопку создания задачи(+)."""){
                MainScreen{
                    buttonIsDisplayedAndClickable(saveButton,needClick = true)
                }
                step("""Открыт экран создания задачи, на экране:
                - Поле "Task Name"
                - Тогл "Mark as Finished"
                - Кнопка выбора даты "Due Date"
                - Кнопка "Subject"
                - Тогл "Mark as Important"
                - Необязательное поле с хинтом "Some ideas or minor details about the task"
                - Кнопкой добавления файла "+ Add"
                - Кнопкой "Save" """){
                    TaskScreen{
                        taskNameInputField.isDisplayed()
                        taskNameInputField.isFocused()
                        taskNameInputField.edit.hasHint("Task Name")

                        switchIsDisplayedAndClickable(finishedMarkSwitch,
                            active = false,
                            needClick = false
                        )

                        buttonIsDisplayedAndClickable(selectEndDateButton,false)

                        buttonIsDisplayedAndClickable(subjectButton,false)

                        switchIsDisplayedAndClickable(markAsImportantSwitch,
                            active = false,
                            needClick = false
                        )

                        subTaskNameEditInputField.isDisplayed()
                        subTaskNameEditInputField.isNotFocused()
                        subTaskNameEditInputField.hasHint("Some ideas or minor details about the task")

                        resourceAddChip.isDisplayed()
                        resourceAddChip.isClickable()

                        buttonIsDisplayedAndClickable(saveButton,false)
                    }
                }
            }
            step("""В поле Task Name набираем "Test 1", скрываем клавиатуру."""){
                TaskScreen{
                    taskNameInputField.edit.replaceText(taskNameText)
                }
                step("""Клавиатура скрыта, текст в поле Task Name введен"""){
                    TaskScreen{
                        taskNameInputField.edit.hasText(taskNameText)
                        buttonIsDisplayedAndClickable(saveButton)
                    }
                }
            }
            step("""Нажимаем на кнопку "Save"."""){
                TaskScreen{
                    buttonIsDisplayedAndClickable(saveButton,true)
                }
                step("""Переходим на экран "Your Tasks", на экране:
                - Заголовок Your Tasks
                - Кнопка Бургер в тулБаре
                - Кнопка "More options"(три точки)
                - Созданая задача "Test 1"
                - Кнопка "Save""""){
                    MainScreen{
                        toolBarText.isDisplayed()
                        buttonIsDisplayedAndClickable(toolBarBurgerButton)
                        buttonIsDisplayedAndClickable(toolBarMoreOptionsButton)
                        taskRecycler{
                            children<MainScreen.TaskItems> {
                                taskName.isDisplayed()
                                taskName.hasText(taskNameText)
                            }
                        }
                        buttonIsDisplayedAndClickable(saveButton)
                    }
                }
            }
        }
    }
    companion object{
        const val taskNameText = "Test 1."
    }
}
