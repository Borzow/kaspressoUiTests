package com.isaiahvonrundstedt.fokus.tests

import androidx.test.ext.junit.rules.activityScenarioRule
import com.isaiahvonrundstedt.fokus.features.core.activities.MainActivity
import com.isaiahvonrundstedt.fokus.screens.MainScreen
import com.isaiahvonrundstedt.fokus.screens.TaskScreen
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
                    buttonStatusCheckAndClick(saveButton,needClick = true)
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

                        switchCheckAndClick(finishedMarkSwitch,
                            active = false,
                            needClick = false
                        )

                        buttonCheckAndClick(selectEndDateButton,false)

                        buttonCheckAndClick(subjectButton,false)

                        switchCheckAndClick(markAsImportantSwitch,
                            active = false,
                            needClick = false
                        )

                        subTaskNameEditInputField.isDisplayed()
                        subTaskNameEditInputField.isNotFocused()
                        subTaskNameEditInputField.hasHint("Some ideas or minor details about the task")

                        resourceAddChip.isDisplayed()
                        resourceAddChip.isClickable()

                        buttonCheckAndClick(saveButton,false)
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
                        buttonCheckAndClick(saveButton)
                    }
                }
            }
            step("""Нажимаем на кнопку "Save"."""){
                TaskScreen{
                    buttonCheckAndClick(saveButton,true)
                }
                step("""Переходим на экран "Your Tasks", на экране:
                - Заголовок Your Tasks
                - Кнопка Бургер в тулБаре
                - Кнопка "More options"(три точки)
                - Созданая задача "Test 1"
                - Кнопкой "Save""""){
                    MainScreen{
                        toolBarText.isDisplayed()
                        buttonStatusCheckAndClick(toolBarBurgerButton)
                        buttonStatusCheckAndClick(toolBarMoreOptionsButton)
                        taskRecycler{
                            children<MainScreen.TaskItems> {
                                taskName.isDisplayed()
                                taskName.hasText(taskNameText)
                            }
                        }
                        buttonStatusCheckAndClick(saveButton)
                    }
                }
            }
        }
    }
    companion object{
        const val taskNameText = "Test 1."
    }
}
