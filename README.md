[![Marathon Logo](https://raw.githubusercontent.com/DevPieter/Marathon/master/docs/images/marathon-icon.svg)](https://modrinth.com/mod/marathon)

# Marathon

[![Modrinth](https://img.shields.io/modrinth/dt/m0IY2Cwx?color=blue&label=Downloads&logo=modrinth)](https://modrinth.com/mod/marathon)
![License](https://img.shields.io/github/license/DevPieter/Marathon?color=blue&label=License&logo=github)

- [Download](#download)
- [Features](#features)
- [Description](#description)
- [Roadmap](#roadmap)

## Download

You can download Marathon on Modrinth: [Download Marathon](https://modrinth.com/mod/marathon)

![Mod loader: Fabric](https://img.shields.io/badge/Modloader-Fabric-1976d2?logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAACXBIWXMAAAsTAAALEwEAmpwYAAAFHGlUWHRYTUw6Y29tLmFkb2JlLnhtcAAAAAAAPD94cGFja2V0IGJlZ2luPSLvu78iIGlkPSJXNU0wTXBDZWhpSHpyZVN6TlRjemtjOWQiPz4gPHg6eG1wbWV0YSB4bWxuczp4PSJhZG9iZTpuczptZXRhLyIgeDp4bXB0az0iQWRvYmUgWE1QIENvcmUgNS42LWMxNDIgNzkuMTYwOTI0LCAyMDE3LzA3LzEzLTAxOjA2OjM5ICAgICAgICAiPiA8cmRmOlJERiB4bWxuczpyZGY9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkvMDIvMjItcmRmLXN5bnRheC1ucyMiPiA8cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0iIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtbG5zOmRjPSJodHRwOi8vcHVybC5vcmcvZGMvZWxlbWVudHMvMS4xLyIgeG1sbnM6cGhvdG9zaG9wPSJodHRwOi8vbnMuYWRvYmUuY29tL3Bob3Rvc2hvcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RFdnQ9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZUV2ZW50IyIgeG1wOkNyZWF0b3JUb29sPSJBZG9iZSBQaG90b3Nob3AgQ0MgMjAxOCAoV2luZG93cykiIHhtcDpDcmVhdGVEYXRlPSIyMDE4LTEyLTE2VDE2OjU0OjE3LTA4OjAwIiB4bXA6TW9kaWZ5RGF0ZT0iMjAxOS0wNy0yOFQyMToxNzo0OC0wNzowMCIgeG1wOk1ldGFkYXRhRGF0ZT0iMjAxOS0wNy0yOFQyMToxNzo0OC0wNzowMCIgZGM6Zm9ybWF0PSJpbWFnZS9wbmciIHBob3Rvc2hvcDpDb2xvck1vZGU9IjMiIHBob3Rvc2hvcDpJQ0NQcm9maWxlPSJzUkdCIElFQzYxOTY2LTIuMSIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDowZWRiMWMyYy1mZjhjLWU0NDEtOTMxZi00OTVkNGYxNGM3NjAiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6MGVkYjFjMmMtZmY4Yy1lNDQxLTkzMWYtNDk1ZDRmMTRjNzYwIiB4bXBNTTpPcmlnaW5hbERvY3VtZW50SUQ9InhtcC5kaWQ6MGVkYjFjMmMtZmY4Yy1lNDQxLTkzMWYtNDk1ZDRmMTRjNzYwIj4gPHhtcE1NOkhpc3Rvcnk+IDxyZGY6U2VxPiA8cmRmOmxpIHN0RXZ0OmFjdGlvbj0iY3JlYXRlZCIgc3RFdnQ6aW5zdGFuY2VJRD0ieG1wLmlpZDowZWRiMWMyYy1mZjhjLWU0NDEtOTMxZi00OTVkNGYxNGM3NjAiIHN0RXZ0OndoZW49IjIwMTgtMTItMTZUMTY6NTQ6MTctMDg6MDAiIHN0RXZ0OnNvZnR3YXJlQWdlbnQ9IkFkb2JlIFBob3Rvc2hvcCBDQyAyMDE4IChXaW5kb3dzKSIvPiA8L3JkZjpTZXE+IDwveG1wTU06SGlzdG9yeT4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz4/HiGMAAAAtUlEQVRYw+XXrQqAMBQF4D2P2eBL+QIG8RnEJFaNBjEum+0+zMQLtwwv+wV3ZzhhMDgfJ0wUSinxZUQWgKos1JP/AbD4OneIDyQPwCFniA+EJ4CaXm4TxAXCC0BNHgLhAdAnx9hC8PwGSRtAFVMQjF7cNTWED8B1cgwW20yfJgAvrssAsZ1cB3g/xckAxr6FmCDU5N6f488BrpCQ4rQBJkiMYh4ACmLzwOQF0CExinkCsvw7vgGikl+OotaKRwAAAABJRU5ErkJggg==)
![Minecraft](https://img.shields.io/badge/Minecraft-1.21.x-1976d2)
![Environment](https://img.shields.io/badge/Environment-client-1976d2)

![Modrinth Version](https://img.shields.io/modrinth/v/m0IY2Cwx?color=blue&label=Version&logo=modrinth)
![Modrinth Game Versions](https://img.shields.io/modrinth/game-versions/m0IY2Cwx?color=blue&label=Game%20Versions&logo=modrinth)

## Features

- **Persistent Toggle**: Once toggled, sprinting and sneaking will remain active until you toggle them off again (even after a restart).
- **Hybrid Keybindings**: Enhanced control over sprinting and sneaking with a single key press.

## Description

**Marathon** enhances Minecraft's vanilla sprinting and sneaking by allowing you to toggle them persistently with a
single key press. No more constant re-toggling or awkward double-taps. With hybrid keybindings and full customization,
it streamlines your movement controls.

#### Default Keybindings

- **Toggle Sprint** =`[` to toggle sprinting on/off
- **Toggle Sneak** = `]` to toggle sneaking on/off
- **Hybrid Sprint** = `Left Ctrl` to sprint while held, double-tap to toggle; inverted when toggled
- **Hybrid Sneak** = `Left Shift` to sneak while held, double-tap to toggle; inverted when toggled

> **Hybrid Keybindings**:
>
> * **Hold** the key to sprint/sneak normally
> * **Double-tap** to toggle sprint/sneak on
> * When toggled, **holding the key inverts the behavior** (i.e., temporarily stops sprinting/sneaking)

#### Keybindings can be changed in the `Controls` menu:

<img src="https://raw.githubusercontent.com/DevPieter/Marathon/master/docs/images/1.png?raw=true" width="800" height="562"></img>

## Roadmap

- [x] Add toggle sprint
- [x] Add toggle sneak
- [x] Add persistent toggle
- [x] Add hybrid keybinding
- [ ] Add hud information
- [ ] Add adjustable hud