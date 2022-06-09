package com.example.jetpackbottompanel

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.discord.panels.OverlappingPanels
import com.discord.panels.rememberOverlappingPanelsState
import com.example.jetpackbottompanel.panel.PanelColumn
import com.example.jetpackbottompanel.panel.PanelHeaderText
import com.example.jetpackbottompanel.panel.PanelSurface
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun ComposeOverlappingPanels() {
    val panelState = rememberOverlappingPanelsState()
    val coroutineScope = rememberCoroutineScope()
    val gesturesEnabled by remember { mutableStateOf(true) }

    OverlappingPanels(
        modifier = Modifier.fillMaxSize(),
        panelsState = panelState,
        enableGestures = gesturesEnabled,
        panelStart = {
            PanelSurface {
                PanelColumn {
                    PanelHeaderText(
                        text = stringResource(id = R.string.start_panel_name),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Button(
                        onClick = {
                            coroutineScope.launch {
                                panelState.closePanels()
                            }
                        }
                    ) {
                        Text(
                            text = stringResource(id = R.string.close_panel_button_text)
                        )
                    }
                }
            }
        },
        panelCenter = {
            PanelSurface {
                PanelColumn {
                    PanelHeaderText(
                        text = stringResource(id = R.string.center_panel_name),
                        modifier = Modifier.align(CenterHorizontally)
                    )
                    Button(
                        onClick = {
                            coroutineScope.launch {
                                panelState.openStartPanel()
                            }
                        }
                    ) {
                        Text(
                            text = stringResource(id = R.string.open_start_panel_button_text)
                        )
                    }
                    Button(
                        onClick = {
                            coroutineScope.launch {
                                panelState.openEndPanel()
                            }
                        }
                    ) {
                        Text(
                            text = stringResource(id = R.string.open_end_panel_button_text)
                        )
                    }
                }
            }
        },
        panelEnd = {
            PanelSurface {
                PanelColumn {
                    PanelHeaderText(
                        text = stringResource(id = R.string.end_panel_name),
                        modifier = Modifier.align(CenterHorizontally)
                    )
                    Button(
                        onClick = {
                            coroutineScope.launch {
                                panelState.closePanels()
                            }
                        }
                    ) {
                        Text(
                            text = stringResource(id = R.string.close_panel_button_text)
                        )
                    }
                }
            }
        }
    )
}