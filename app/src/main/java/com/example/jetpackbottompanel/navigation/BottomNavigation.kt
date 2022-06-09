package com.example.jetpackbottompanel.navigation

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.example.jetpackbottompanel.R
import com.example.jetpackbottompanel.ui.theme.Green
import com.example.jetpackbottompanel.ui.theme.Purple500
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@ExperimentalMaterialApi
@Composable
fun BottomNavigation() {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val images = listOf(
        R.drawable.apple,
        R.drawable.banana,
        R.drawable.grapes,
        R.drawable.cherries
    )
    val pageState = rememberPagerState(initialPage = 0)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Bottom Navigation Swipe Screen"
                    )
                },
                actions = {
                    IconButton(onClick = {
                        Toast.makeText(context, "Search", Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = "Icon")
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar (
                backgroundColor = MaterialTheme.colors.primary
            ) {
                for (page in images.indices) {
                    BottomNavigationItem(
                        selected = page == pageState.currentPage,
                        onClick = {
                            scope.launch {
                                pageState.animateScrollToPage(page)
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.Home,
                                contentDescription = "Page $page"
                            )
                        },
                        selectedContentColor = Color.Green,
                        unselectedContentColor = Color.LightGray,
                        label = {
                            Text(
                                text = "Page ${page.plus(1)}"
                            )
                        }
                    )
                }
            }
        }
    ) {
        HorizontalPager(count = images.size, state = pageState) {
            Image(
                painter = painterResource(id = images[it]),
                contentDescription = "Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }
}