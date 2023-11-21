package com.example.barbearia.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.barbearia.R
import com.example.barbearia.model.Barbeiro

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarbeiroScreen(
    barbeiro: Barbeiro = Barbeiro(id = "1", nome = "Raniere Luiz", isFavorite = true),
) {
    Scaffold(
        topBar = {
            AppBar(title = barbeiro.nome, isFavorite = barbeiro.isFavorite)
        },
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            ImageGallery()
            Content()
        }
    }
}

@Composable
private fun Content() {
    Column(modifier = Modifier.padding(12.dp)) {
        Text(
            "R$ 19,99",
            fontSize = 42.sp,
        )
        Separator()
        Spacer(modifier = Modifier.height(12.dp))
        Text("Descrição", fontSize = 22.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            "Sou o Raniere, o talentoso barbeiro por trás da BarberShop . Com mais de 10 anos de experiência, trago expertise moderna e clássica para cada corte. Especializado em cortes estilosos, barbas impecáveis e tratamentos capilares premium. No nosso ambiente descontraído, garantimos um atendimento personalizado e compromisso com a qualidade. Agende agora para uma experiência única na Barbershop",
            fontSize = 18.sp,
            color = Color.Gray,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
        )
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text("Ver descrição completa")
        }
        Spacer(modifier = Modifier.height(12.dp))

        HorariosDisponiveis(
            horarios = listOf("09:00", "10:00", "11:00", "12:00", "13:00"),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun Separator() {
    Box(
        modifier =
        Modifier
            .height(1.dp)
            .fillMaxWidth()
            .background(Color.LightGray),
    ) {}
}

@Composable
private fun ImageGallery() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .background(Color.Transparent)
                .fillMaxWidth()
                .height(260.dp)
                .weight(1f),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.imagem_barbeiro_1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            )
        }

    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun AppBar(title: String, isFavorite: Boolean) {
    val favoriteIcon = if (isFavorite) {
        painterResource(id = R.drawable.ic_favorite)
    } else {
        painterResource(id = R.drawable.ic_favorite_border)
    }

    TopAppBar(
        title = {
            Text(title)
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(
                    painter = favoriteIcon,
                    contentDescription = null,
                    tint = Color.White,
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color(0xFFFFA500),
            titleContentColor = Color.White,
        ),
    )
}

@Composable
fun HorariosDisponiveis(
    horarios: List<String>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier) {
        items(horarios) { horario ->
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Horário
                    Text(
                        text = horario,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp)
                    )

                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFFA500),
                        ),
                        onClick = {},
                        modifier = Modifier.padding(end = 2.dp),
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_agenda),
                            contentDescription = null,
                            modifier = Modifier.padding(end = 12.dp),
                        )
                        Text("Agendar", fontSize = 16.sp)

                    }
                }
            }
        }
    }
}


