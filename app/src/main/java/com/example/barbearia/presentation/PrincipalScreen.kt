package com.example.barbearia.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.barbearia.R
import com.example.barbearia.model.Barbeiro

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrincipalScreen() {
    Scaffold(
        topBar = {
            AppBar()
        },
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            Image(
                painter = painterResource(id = R.drawable.barbershop_logo),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(Color.Transparent)
                    .padding(8.dp)
            )

            BarberCarousel()
            Text("NOSSA HISTÓRIA", fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 16.dp))
            Text(
                "Somos a BarberShop, uma barbearia de alta qualidade que oferece serviços excepcionais há mais de uma década. Nossa missão é proporcionar a melhor experiência de cuidado com os cabelos e barba, combinando técnicas modernas e clássicas. Venha nos visitar e descubra o que torna a BarberShop única!",
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 8.dp)
            )

            // Adicione o texto e ícone do Instagram
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_instagram),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "@Barbeshop",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                )
            }

            // Adicione o texto e ícone do WhatsApp
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_whatsapp),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "(083)99871-9876",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                )
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun AppBar() {
    TopAppBar(
        title = {
            Text("BarberShop")
        },

        actions = {
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_sanduba),
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
fun BarberCarousel(
    barbeiros: List<Barbeiro> = listOf(
        Barbeiro(id = "1", nome = "Raniere Luiz", urlImage = "imagem_barbeiro_1.png"),
        Barbeiro(id = "2", nome = "Arthur Alves", urlImage = "barbeiro_2.png"),
        Barbeiro(id = "3", nome = "Alysson Jerônimo", urlImage = "barbeiro_3.png")
    ),
) {
    LazyRow {
        items(barbeiros) { barbeiro ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = getImageResourceId(barbeiro.urlImage)),
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(shape = RoundedCornerShape(8.dp))
                        .background(Color.Black)
                        .padding(4.dp)
                )
                Text(
                    text = barbeiro.nome,
                    modifier = Modifier.padding(top = 4.dp),
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis

                )
            }
        }
    }
}

@Composable
fun getImageResourceId(imageName: String): Int {
    return when (imageName) {
        "imagem_barbeiro_1.png" -> R.drawable.imagem_barbeiro_1
        "barbeiro_2.png" -> R.drawable.barbeiro_2
        "barbeiro_3.png" -> R.drawable.barbeiro_3
        else -> R.drawable.ic_launcher_foreground
    }
}

@Composable
@Preview(showBackground = true, widthDp = 280)
fun SearchScreenPreview() {
    PrincipalScreen()
}
