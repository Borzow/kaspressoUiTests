package com.isaiahvonrundstedt.fokus.kTests.screens

import com.isaiahvonrundstedt.fokus.R
import com.isaiahvonrundstedt.fokus.kTests.FrequencyTestChecks
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.chipgroup.KChipGroup
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.edit.KTextInputLayout
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.toolbar.KToolbar

object TaskScreen:KScreen<TaskScreen>(),FrequencyTestChecks {
    override val layoutId: Int?=null
    override val viewClass: Class<*>?=null

    val toolBar = KToolbar {withId(R.id.toolbar)}
    val toolBarMoreOptionsButton = KButton{
        withContentDescription("More options")
        withParent { this@TaskScreen.toolBar }
    }
    val taskNameInputField = KTextInputLayout{withId(R.id.taskNameTextInputLayout)}
    val finishedMarkSwitch = KSwitch {withId(R.id.statusSwitch)}
    val selectEndDateButton = KButton {withId(R.id.dueDateTextView)}
    val subjectButton = KButton {withId(R.id.subjectTextView)}
    val markAsImportantSwitch = KSwitch {withId(R.id.prioritySwitch)}
    val subTaskNameEditInputField = KEditText{withId(R.id.notesTextInput)}
    val resourceAddChip = KChipGroup{withId(R.id.addActionChip)}

    val saveButton = KButton { withId(R.id.actionButton) }
}