# Generated by Django 2.1.7 on 2019-04-16 12:39

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('bookclub_server', '0001_initial'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='user',
            name='surname',
        ),
    ]
