$csv = Import-Csv .\backlog-infra-setup.csv

Write-Host "Loaded $($csv.Count) items from CSV"

# Collect all unique labels from the CSV, split by ',' and trim spaces
$allLabels = $csv | ForEach-Object { $_.Labels -split ',' } | ForEach-Object { $_.Trim() } | Where-Object { $_ -ne "" } | Select-Object -Unique

foreach ($label in $allLabels) {
    gh label create "$label" --color "ededed" --force 2>$null
}

foreach ($row in $csv) {
    $title = $row.Title
    $body = $row.Description
    # Split and trim labels for this issue
    $labels = ($row.Labels -split ',' | ForEach-Object { $_.Trim() }) -join ','

    Write-Host "Creating issue: $title"
    if ($labels -and $labels.Trim() -ne "") {
        gh issue create -t "$title" -b "$body" -l "$labels"
    } else {
        gh issue create -t "$title" -b "$body"
    }
}