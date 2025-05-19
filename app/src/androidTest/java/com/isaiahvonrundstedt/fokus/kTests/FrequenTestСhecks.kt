package com.isaiahvonrundstedt.fokus.kTests

import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton

interface FrequencyTestChecks {

    fun buttonIsDisplayedAndClickable(button: KButton, needClick: Boolean = false) {
        button.isDisplayed()
        button.isClickable()
        if (needClick) button.click()
    }

    fun switchIsDisplayedAndClickable(switch: KSwitch, needClick: Boolean = false) {
        switch.isDisplayed()
        switch.isClickable()
        if (needClick) {
            switch.click()
            switch.isChecked()
        }
    }
}