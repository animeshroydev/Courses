package com.appmakerszone.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appmakerszone.courses.data.DataSource
import com.appmakerszone.courses.model.Courses
import com.appmakerszone.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesTheme {
                CoursesApp()
            }
        }
    }

    @Composable
    fun CoursesApp() {

            CoursesList(coursesList = DataSource().loadCourses())

    }

    @Composable
    fun CoursesCard(courses: Courses, modifier: Modifier = Modifier) {

        Card(
            modifier = modifier
                .height(100.dp)
                .padding(10.dp)
        ) {


            Row {
                Box {
                Image(
                    painter = painterResource(
                        id = courses.imgResourceId
                    ),
                    contentDescription = stringResource(id = courses.stringResourceId),
                    modifier = Modifier.width(68.dp).height(110.dp),
                    contentScale = ContentScale.Crop
                )
                }
                Column {
                    Text(
                        text = stringResource(id = courses.stringResourceId),
                        modifier = Modifier.padding(
                            start = 16.dp,
                            end = 16.dp,
                            top = 5.dp
                        ),
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Row {

                        Icon(
                            painter = painterResource(id = R.drawable.ic_grain),
                            contentDescription = null,
                            modifier = Modifier.padding(
                                start = 16.dp,
                                top = 6.dp,
                            )
                        )

                        Text(
                            text = (courses.num).toString(),
                            modifier = Modifier.padding(
                                start = 16.dp,
                                end = 16.dp,
                                top = 10.dp,
                            ),
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun CoursesList(coursesList: List<Courses>, modifier: Modifier = Modifier) {

        LazyVerticalGrid(columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier) {
            items(coursesList) { courses ->
                    CoursesCard(courses = courses)
            }
        }
    }



    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun GreetingPreview() {
        CoursesTheme {
//            CoursesCard(Courses(R.string.film, R.drawable.tech, 44))
            CoursesApp()
        }
    }
}