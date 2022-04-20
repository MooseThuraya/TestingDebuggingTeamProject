using System.Reflection;
using System.ComponentModel;

namespace SuperStarTrek.Commands;

public static class CommandExtensions
{
    public static string GetDescription(this Command command) =>
        typeof(Command)
            .GetField(command.ToString())
            .GetCustomAttribute<DescriptionAttribute>()
            .Description;
}