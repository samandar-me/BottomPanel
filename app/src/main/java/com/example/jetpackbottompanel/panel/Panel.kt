package com.example.jetpackbottompanel.panel

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.jetpackbottompanel.ComposeOverlappingPanels

@ExperimentalMaterialApi
@Composable
fun Panel() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Compose Overlapping Panels",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            )
        }
    ) {
        ComposeOverlappingPanels()
    }
}